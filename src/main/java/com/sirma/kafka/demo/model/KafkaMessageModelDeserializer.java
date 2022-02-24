package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.sirma.kafka.demo.common.KafkaErrorMessages;
import com.sirma.kafka.demo.common.KafkaMessageJsonFieldConstants;
import com.sirma.kafka.demo.enums.EventType;
import com.sirma.kafka.demo.enums.TaskModelType;
import org.apache.commons.lang3.EnumUtils;

import java.io.IOException;
import java.util.ArrayList;

public class KafkaMessageModelDeserializer extends StdDeserializer<KafkaMessageModel> {

    protected KafkaMessageModelDeserializer() {
        this(null);
    }

    protected KafkaMessageModelDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public KafkaMessageModel deserialize(
            JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        JsonNode task = getJsonTask(node, KafkaMessageJsonFieldConstants.TASK);
        EventType eventType = getJsonEventType(jsonParser, node, KafkaMessageJsonFieldConstants.EVENT_TYPE);
        TaskModelType taskModelType = getJsonTaskModelType(jsonParser, node, KafkaMessageJsonFieldConstants.TASK_MODEL_TYPE);
        String tenantId = getJsonStringValue(node, KafkaMessageJsonFieldConstants.TENANT_ID);
        String tenantUrl = getJsonStringValue(node, KafkaMessageJsonFieldConstants.TENANT_URL);
        String processorDisplayName = getJsonStringValue(node, KafkaMessageJsonFieldConstants.PROCESSOR_DISPLAY_NAME);
        String processorEmail = getJsonStringValue(node, KafkaMessageJsonFieldConstants.PROCESSOR_EMAIL);
        ArrayList<RecipientModel> recipientsEmail = getJsonRecipientsEmail(node, KafkaMessageJsonFieldConstants.RECIPIENTS_EMAIL);

        return new KafkaMessageModel(task, eventType, taskModelType, tenantId, tenantUrl, processorEmail, processorDisplayName, recipientsEmail);
    }

    private ArrayList<RecipientModel> getJsonRecipientsEmail(JsonNode node, String field) {
        JsonNode arrayNode = node.get(field);

        ArrayList<RecipientModel> recipientModels = new ArrayList<>();
        if (arrayNode != null && arrayNode.isArray()) {
            for (JsonNode jsonNode : arrayNode) {
                String displayName = getStringValueFromJsonNode(jsonNode, KafkaMessageJsonFieldConstants.DISPLAY_NAME);
                String email = getStringValueFromJsonNode(jsonNode, KafkaMessageJsonFieldConstants.EMAIL);
                RecipientModel recipientModel = new RecipientModel(displayName, email);
                recipientModels.add(recipientModel);
            }
        }
        return recipientModels;
    }

    private String getStringValueFromJsonNode(JsonNode jsonNode, String field) {
        JsonNode node = jsonNode.get(field);
        return node != null && node.isTextual() ? node.asText() : "";
    }

    private String getJsonStringValue(JsonNode node, String field) {
        JsonNode jsonNode = node.get(field);
        return jsonNode != null && jsonNode.isTextual() ? jsonNode.asText() : null;
    }

    private TaskModelType getJsonTaskModelType(JsonParser jsonParser, JsonNode node, String field) throws JsonMappingException {
        JsonNode taskModelType = node.get(field);
        if (taskModelType == null || !EnumUtils.isValidEnum(TaskModelType.class, taskModelType.asText())) {
            throw JsonMappingException.from(jsonParser, KafkaErrorMessages.TASK_MODEL_TYPE_INVALID_DATA);
        }
        return TaskModelType.valueOf(taskModelType.asText());
    }

    private EventType getJsonEventType(JsonParser jsonParser, JsonNode node, String field) throws JsonMappingException {
        JsonNode eventTypeNode = node.get(field);
        if (eventTypeNode == null || !EnumUtils.isValidEnum(EventType.class, eventTypeNode.asText())) {
            throw JsonMappingException.from(jsonParser, KafkaErrorMessages.EVENT_TYPE_INVALID_DATA);
        }
        return EventType.valueOf(eventTypeNode.asText());
    }

    private JsonNode getJsonTask(JsonNode node, String field) {
        JsonNode task = node.get(field);
        if (task != null && !task.isObject()) {
            task = null;
        }
        return task;
    }
}
