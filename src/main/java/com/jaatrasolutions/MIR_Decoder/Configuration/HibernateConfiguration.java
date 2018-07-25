package com.jaatrasolutions.MIR_Decoder.Configuration;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.jaatrasolutions.MIR_Decoder.Configuration" })
@PropertySource(value = { "file:///E:/Jaatra Solutions/application.properties" })
public class HibernateConfiguration {
	@Autowired
	Environment env;
}