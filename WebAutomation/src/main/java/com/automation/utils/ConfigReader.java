package com.automation.utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigReader {
	private Map<String, Object> yamlData;

	public ConfigReader(String yamlPath) {

		InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(yamlPath);

		if (inputStream == null) {
			throw new RuntimeException("YAML file not found at path: " + yamlPath);
		}
		Yaml yaml = new Yaml();
		yamlData = yaml.load(inputStream);
		if (yamlData == null) {
			throw new RuntimeException("❌ YAML file is empty or invalid: " + yamlPath);
		}
	}

	public String getValueByKey(String key) throws Exception {

		Object value = yamlData.get(key);

		if (value == null) {
			throw new RuntimeException("Value is not there in config file for given Key");
		}
		return value.toString();
	}

	public String getParentChildValue(String parent, String child) {
		Map<String, Object> nestedMap = (Map<String, Object>) yamlData.get(parent);
		return nestedMap.get(child).toString();
	}

	public String getValueByNestedKeys(String... keys) {
		Object value = yamlData;

		for (String key : keys) {
			if (!(value instanceof Map)) {
				throw new RuntimeException("YAML section at: " + key + " is not present");
			}

			value = ((Map<String, Object>) value).get(key);

			if (value == null) {
				throw new RuntimeException(" Key not found: " + key);
			}
		}
		return value.toString();

	}

}
