package fr.epita.assistants.nucbattle;

// ReportType.java
import com.fasterxml.jackson.annotation.JsonProperty;

enum ReportType {
    WINNER("winner"), CHEATER("cheater"), ERROR("error"), UNFINISHED("unfinished");

    private final String type;

    ReportType(String type) {
        this.type = type;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }
}