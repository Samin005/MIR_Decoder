package com.jaatrasolutions.MIR_Decoder;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jaatrasolutions.MIR_Decoder.Controller.DecoderController;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MirDecoderApplication {

	//@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MirDecoderApplication.class);
    }
	
	public static void main(String[] args) throws BeansException{
		ConfigurableApplicationContext context = SpringApplication.run(MirDecoderApplication.class, args);
        context.getBean(DecoderController.class).start();
	}
}
