package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Map;

class TurnDeserializer extends JsonDeserializer<Turn> {
    private final Map<String, Nuc> nucs;

    public TurnDeserializer(Map<String, Nuc> nucs) {
        this.nucs = nucs;
    }

    @Override
    public Turn deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectNode node = p.getCodec().readTree(p);
        String playerLogin = node.get("player_login").asText();
        String targetLogin = node.get("target_login").asText();
        Packet packet = new ObjectMapper().treeToValue(node.get("packet"), Packet.class);

        return new Turn(nucs.get(playerLogin), playerLogin, nucs.get(targetLogin), targetLogin, packet);
    }
}