package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BattleManager {
    private final String filePath;
    private Battle battle;

    public BattleManager(String path) throws IOException {
        this.filePath = path;
        ObjectMapper objectMapper = new ObjectMapper();
        this.battle = objectMapper.readValue(new File(path), Battle.class);
    }

    public void computeBattle(String reportPath) throws IOException {
        Map<String, Float> healthMap = new HashMap<>();
        for (Turn turn : battle.getTurns()) {
            healthMap.put(turn.getPlayerNuc().getName(), turn.getPlayerNuc().getHp());
        }

        for (Turn turn : battle.getTurns()) {
            if (!turn.getPlayerNuc().getInstalledPrograms().containsAll(turn.getPacket().getUsedPrograms())) {
                new ObjectMapper().writeValue(new File(reportPath), new Report(ReportType.CHEATER, turn.getPlayerNuc().getName(), null));
                return;
            }
            float newHp = Math.max(0, Math.min(100, healthMap.get(turn.getTargetNuc().getName()) - turn.getPacket().getDamage()));
            healthMap.put(turn.getTargetNuc().getName(), newHp);
        }

        String winner = healthMap.entrySet().stream().filter(e -> e.getValue() > 0).map(Map.Entry::getKey).findFirst().orElse(null);
        if (winner != null && healthMap.values().stream().filter(hp -> hp > 0).count() == 1) {
            new ObjectMapper().writeValue(new File(reportPath), new Report(ReportType.WINNER, winner, healthMap));
        } else {
            new ObjectMapper().writeValue(new File(reportPath), new Report(ReportType.UNFINISHED, null, healthMap));
        }
    }
}