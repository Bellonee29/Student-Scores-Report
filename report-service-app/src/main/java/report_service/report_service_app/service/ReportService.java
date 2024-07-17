package report_service.report_service_app.service;


import org.springframework.stereotype.Service;

public interface ReportService {
    Double calculateMean(Integer studentRegNo);

    Double calculateMedian(Integer studentRegNo);
    Double calculateMode(Integer studentRegNo);

}
