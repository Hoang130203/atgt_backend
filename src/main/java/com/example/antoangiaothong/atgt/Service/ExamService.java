package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.Exam;
import com.example.antoangiaothong.atgt.Entity.Question;

import java.util.Collection;

public interface ExamService {
    Exam insertExam(Exam exam);
    Collection<Exam> getListExam();
    Exam getExamById(int id);
}
