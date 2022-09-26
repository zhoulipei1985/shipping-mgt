package com.cn.zlp.shipping.mgt.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages={"com.cn.zlp"})
@MapperScan(basePackages = "com.cn.zlp.mapper")
public class ShippingMgtApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShippingMgtApplication.class, args);

	}

}
