package report_service.report_service_app.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double englishScore;

    private Double mathematicsScore;

    private Double physicsScore;

    private Double computerScore;

    private Double chemistryScore;

    private Double mean;

    private Double median;

    private Double mode;

    private Double studentRegNo;






}
