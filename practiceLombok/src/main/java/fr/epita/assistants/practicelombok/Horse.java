package fr.epita.assistants.practicelombok;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter  @EqualsAndHashCode(of = {"name", "nickname"})
@ToString(exclude = "nickname")

public class Horse {
    @Setter private String name;
    @Setter private String nickname;
    private int speed;
}