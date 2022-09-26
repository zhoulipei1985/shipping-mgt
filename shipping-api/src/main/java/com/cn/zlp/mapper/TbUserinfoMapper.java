package com.cn.zlp.mapper;

import com.cn.zlp.user.pojo.TbUserinfo;
import com.cn.zlp.user.pojo.TbUserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserinfoMapper {

   public TbUserinfo selectByUserName(String userName);

  public  void  insertSelective(TbUserinfo userinfo);


}