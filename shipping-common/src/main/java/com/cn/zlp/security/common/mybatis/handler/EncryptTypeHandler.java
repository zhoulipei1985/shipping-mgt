package com.cn.zlp.security.common.mybatis.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.AES;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String.class)
public class EncryptTypeHandler extends BaseTypeHandler<String> {

    private static final byte[] KEYS = "12345678asdfghjk".getBytes(StandardCharsets.UTF_8);
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if (StringUtil.isNullOrEmpty(s)) {
            preparedStatement.setString(i, null);
            return;
        }

        AES aes = SecureUtil.aes(KEYS);
        String encryptStr = aes.encryptHex(s);
        preparedStatement.setString(i, encryptStr);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
             return decrypt(resultSet.getString(columnName));

    }

    @Override
    public String getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {

        return decrypt(resultSet.getString(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return decrypt(callableStatement.getString(columnIndex));
    }

    private String decrypt(String value) {
        if (null == value){
            return null;
        }
       return SecureUtil.aes(KEYS).decryptStr(value);
    }


}
