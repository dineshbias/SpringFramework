/**
 * 
 */
package com.spring.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author dinesh.joshi
 *
 */
public class SampleTest {

	public static void main(String[] args) throws IOException {
		System.out.println("Running..");
		byte[] jsonData = Files.readAllBytes(Paths.get("C:\\user.txt"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// read JSON like DOM Parser
		try {
			JsonNode initialNode = objectMapper.readTree(jsonData);

			ArrayNode arrayNode = (ArrayNode) initialNode.get("Resources");
			if (null != arrayNode) {
				JsonNode node = arrayNode.get(0);
				long id = ((com.fasterxml.jackson.databind.node.LongNode) node.get("id")).asLong();
				String email = ((com.fasterxml.jackson.databind.node.TextNode) node.get("userName")).asText();
				String node4 = ((com.fasterxml.jackson.databind.node.TextNode) node.get("name").get("formatted"))
						.asText();
				
				Iterator<JsonNode> iterator = arrayNode.iterator();
				int i = 0;
				while (iterator.hasNext()) {
					JsonNode userDetailNode = iterator.next();
					JsonNode name = userDetailNode.get("name");

				}
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
