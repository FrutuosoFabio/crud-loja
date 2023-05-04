package com.crud.loja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"com.crud.loja.es.repositories","com.crud.loja.entities"})
@EnableMongoRepositories(basePackages = {"com.crud.loja.mongo.repositories","com.crud.loja.entities"})
@ComponentScan(basePackages = { "com.crud.loja.*" })
public class crudLojaApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(crudLojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
	}
}
