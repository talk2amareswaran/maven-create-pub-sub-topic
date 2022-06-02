package com.educative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.spring.pubsub.PubSubAdmin;

@SpringBootApplication
public class CreatePubSubTopicApplication implements CommandLineRunner {

	@Autowired
	private PubSubAdmin pubSubAdmin;

	@Value("${app.pubsub.topic_id}")
	private String topicId;

	public static void main(String[] args) {
		SpringApplication.run(CreatePubSubTopicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Provided topicId:"+topicId);
		if (topicId == null || "{{topic_id}}".equals(topicId)) {
			System.out.println("Please provide a Topic ID");
			return;
		}
		pubSubAdmin.createTopic(topicId);
		System.out.println("Topic ID " + topicId + " created successfully");
	}

}
