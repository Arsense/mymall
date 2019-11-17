package com.macro.mymall.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 */
@SpringBootApplication
public class ShopApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ShopApplication.class);


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ShopApplication.class, args);
		//输入访问链接
		String serverPort = context.getEnvironment().getProperty("server.port");
		LOG.info("MyMall started at http://localhost:" + serverPort);
		LOG.info("api文档列表  http://localhost:" + serverPort + "/swagger-ui.html");

	}

}
