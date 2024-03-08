package com.example.antoangiaothong.atgt.Controller;

import com.example.antoangiaothong.atgt.Entity.Exam;
import com.example.antoangiaothong.atgt.Service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/postExamAndQuestions")
    public ResponseEntity<?> postExam(@RequestBody Exam exam ,@RequestParam String ownerId){
        try {
            Exam exam1= examService.insertExam(exam);
            return ResponseEntity.ok(exam1.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("error");
        }

    }

    @GetMapping("/getListExams")
    public ResponseEntity<Collection<Exam>> getExams(){
        return ResponseEntity.ok(examService.getListExam());
    }

    @GetMapping("/getExamById")
    public ResponseEntity<?> getExamById(@RequestParam int id){
        return ResponseEntity.ok(examService.getExamById(id));
    }
}
