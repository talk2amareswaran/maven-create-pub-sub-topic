package com.educative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import com.google.cloud.spring.pubsub.PubSubAdmin;

@SpringBootApplication
public class CreatePubSubTopicApplication implements CommandLineRunner {

	@Autowired
	private PubSubAdmin pubSubAdmin;

	private String topicId = "{{topic_id}}";

	public static void main(String[] args) {
		SpringApplication.run(CreatePubSubTopicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (!StringUtils.hasLength(topicId)) {
			System.out.println("Please provide a Topic ID");
			return;
		}
		pubSubAdmin.createTopic(topicId);
		System.out.println("Topic ID \"" + topicId + "\" created successfully");
	}

}
