package com.tenable.gift.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableConfigurationProperties
public class RootConfig {

	private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);

	@Bean
	Map<String, List<String>> giftsHistory() {

		logger.info("Loading History");

		Map<String, Object> map = new HashMap<String, Object>();

		YamlMapFactoryBean factory = new YamlMapFactoryBean();
		factory.setResources(new ClassPathResource[] { new ClassPathResource("application.yml") });
		map = factory.getObject();

		Map<String, Map<String, String>> historyMap = (Map<String, Map<String, String>>) map.get("history");

		Map<String, List<String>> result = new HashMap<String, List<String>>();

		for (Map<String, String> mp : historyMap.values()) {
			for (String st : mp.keySet()) {
				result.putIfAbsent(st, new ArrayList<String>());
				result.get(st).add(new String(mp.get(st)));
			}
		}
		
		return result;
	}

}
