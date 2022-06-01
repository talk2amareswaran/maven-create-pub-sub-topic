package com.educative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.spring.pubsub.PubSubAdmin;

@SpringBootApplication
public class CreatePubSubTopicApplication implements CommandLineRunner {

	@Autowired
	private PubSubAdmin pubSubAdmin;

	public static void main(String[] args) {
		SpringApplication.run(CreatePubSubTopicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pubSubAdmin.createTopic("order");

	}

}