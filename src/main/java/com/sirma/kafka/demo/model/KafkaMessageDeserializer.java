package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class KafkaMessageDeserializer extends StdDeserializer<KafkaMessage> {

  private static final String EMAILS = "emails";

  public KafkaMessageDeserializer() {
    this(null);
  }

  public KafkaMessageDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public KafkaMessage deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    JsonNode dataNode = node.get("data");
    if (dataNode != null && !dataNode.isObject()) {
      dataNode = null;
    }

    JsonNode tenantUrlNode = node.get("tenantUrl");
    String tenantUrl =
        tenantUrlNode != null && tenantUrlNode.isTextual() ? tenantUrlNode.asText() : null;

    JsonNode displayNameNode = node.get("displayName");

    String displayName =
        displayNameNode != null && displayNameNode.isTextual() ? displayNameNode.asText() : null;

    ArrayList<String> emails = new ArrayList<>();
    JsonNode jsonNodeEmails = node.get(EMAILS);
    if (jsonNodeEmails != null && node.get(EMAILS).isArray()) {
      for (JsonNode jsonNode : node.get(EMAILS)) {
        emails.add(jsonNode.asText());
      }
    }

    return new KafkaMessage(dataNode, tenantUrl, displayName, emails);
  }
}
