package score_service.score_service_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import score_service.score_service_app.dto.reponse.GenericResponse;
import score_service.score_service_app.dto.request.ScoreDto;
import score_service.score_service_app.entities.Subject;
import score_service.score_service_app.service.ScoreService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("app/scores")
public class scoreController {


    private final ScoreService scoreService;

    @PostMapping("/addScores")
    public ResponseEntity<String> addScores(@RequestBody ScoreDto scoreDTO) {
        scoreService.addScores(scoreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Scores added successfully");
    }


    @GetMapping("getSubjectScore/{studentRegNo}")
    public ResponseEntity<GenericResponse<Map<String, Double>>> getSubjectScoreByStudentRegNo(@PathVariable Integer studentRegNo) {
        ResponseEntity<GenericResponse<Map<String, Double>>> responseEntity;

        GenericResponse<Map<String, Double>> response = scoreService.getSubjectScoreByStudentRegNo(studentRegNo);

        if (response.getHttpStatus() == HttpStatus.OK) {
            responseEntity = ResponseEntity.ok(response);
        } else {
            responseEntity = ResponseEntity.status(response.getHttpStatus()).body(response);
        }

        return responseEntity;
    }





}
