package com.educative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.UnavailableException;
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
	public void run(String... args) {

		if (!StringUtils.hasLength(topicId)) {
			System.out.println("Please provide a Topic ID");
			return;
		}

		try {
			pubSubAdmin.createTopic(topicId);
			System.out.println("\n Topic ID \"" + topicId + "\" created successfully \n");
		} catch (AlreadyExistsException ae) {
			System.out.println("\n"+ae.getMessage()+"\n");
		} catch (UnavailableException uae) {
			System.out.println("\n"+uae.getMessage()+"\n");
		} catch (Exception e) {
			System.out.println("\n"+e.getMessage()+"\n");
		}

	}

}
