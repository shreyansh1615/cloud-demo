package com.example.clouddemo;

import com.example.clouddemo.config.ServerConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class CloudDemoApplication {

	@Autowired
	private ServerConfig serverConfig;

	public static void main(String[] args) {
		SpringApplication.run(CloudDemoApplication.class, args);
		//readIndividualConfigmapKey();
		//loadThePropertyFileFromMountPath();
		//getDirectoryFiles();
	}

	private static void readIndividualConfigmapKey() {
		try {
			String configValue = new String(Files.readAllBytes(Paths.get("/etc/config/application.properties"))); //application.properties is stored as key in configmap
			System.out.println("ConfigMap Value for key2 : " + configValue);
		} catch (IOException e) {
			System.err.println("Error reading ConfigMap value: " + e.getMessage());
		}
	}

	private static void loadThePropertyFileFromMountPath() {
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("/etc/config/application.properties")) {
			properties.load(fis);

			// Get properties
			String fareMsg = properties.getProperty("farewell.message");
			String greetingMsg = properties.getProperty("greeting.message");
			log.info("fareMsg {} greetingMsg {}",fareMsg,greetingMsg);
		}
		catch (Exception e)
		{

		}
	}

	private static void getDirectoryFiles() {
		File directory = new File("/etc/config");

		File[] files = directory.listFiles();

		// Iterate over the files and print their names
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					System.out.println("File Name = "+file.getName());
				}
			}
		}
	}

	@PostConstruct
	public void checkServerConfigInstance(){
		log.info(serverConfig.showMyProperty());
	}

}
