package com.macro.mymall.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AdminApplication {

	private static final Logger LOG = LoggerFactory.getLogger(AdminApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AdminApplication.class, args);

		String serverPort = context.getEnvironment().getProperty("server.port");
		//输入访问链接
		LOG.info("MyMall started at http://localhost:" + serverPort);
	}

}
