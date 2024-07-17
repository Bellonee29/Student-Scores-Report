package score_service.score_service_app.dto.request;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class ScoreDto {
    private Double englishScore;
    private Double mathematicsScore;
    private Double physicsScore;
    private Double computerScore;
    private Double chemistryScore;
    private Integer studentRegNo;
}
