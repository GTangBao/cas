package com.goodidea.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement
@SpringBootApplication 
@ServletComponentScan

//public class App extends org.springframework.boot.web.support.SpringBootServletInitializer {
public class App {



	public static void main(String[] args) {  
          SpringApplication.run(App.class, args);
	}  
}
