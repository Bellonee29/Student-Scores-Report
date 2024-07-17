package report_service.report_service_app.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import report_service.report_service_app.dto.Subject;
import report_service.report_service_app.feign.ReportFeignInterface;

import java.util.Arrays;


@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService{


    private ReportFeignInterface reportFeignInterface;

    @Override
    public Double calculateMean(Integer studentRegNo) {
        Subject subject = reportFeignInterface.getSubjectScoreByStudentRegNo(studentRegNo);
        if (subject == null) {
            // Handle case where subject is not found for studentRegNo
            return 0.0;
        }
        Double[] scores = {subject.getEnglishScore(), subject.getMathematicsScore(),
                subject.getPhysicsScore(), subject.getComputerScore(),
                subject.getChemistryScore()};
        double sum = Arrays.stream(scores)
                .mapToDouble(Double::doubleValue)
                .sum();
        return sum / scores.length;
    }

    @Override
    public Double calculateMedian(Integer studentRegNo) {
        Subject subject = reportFeignInterface.getSubjectScoreByStudentRegNo(studentRegNo);
        if (subject == null) {
            return 0.0;
        }
        Double[] scores = {subject.getEnglishScore(), subject.getMathematicsScore(),
                subject.getPhysicsScore(), subject.getComputerScore(),
                subject.getChemistryScore()};
        Arrays.sort(scores);
        double middle = (double) (scores.length / 2);
        if (scores.length % 2 == 0) {
            return (scores[(int) (middle - 1)] + scores[(int) middle]) / 2;
        } else {
            return scores[(int) middle];
        }
    }

    @Override
    public Double calculateMode(Integer studentRegNo) {

        Subject subject = reportFeignInterface.getSubjectScoreByStudentRegNo(studentRegNo);
        if (subject == null) {
            return 0.0;
        }
        Double[] scores = {subject.getEnglishScore(), subject.getMathematicsScore(),
                subject.getPhysicsScore(), subject.getComputerScore(),
                subject.getChemistryScore()};
        int maxCount = 0;
        Double mode = (double) 0;
        for (Double score : scores) {
            int count = 0;
            for (Double aDouble : scores) {
                if (aDouble == score)
                    ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                mode = score;
            }
        }
        return mode;
    }
}
