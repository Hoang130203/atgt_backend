package com.example.antoangiaothong.atgt.Service;

import com.example.antoangiaothong.atgt.Entity.Exam;
import com.example.antoangiaothong.atgt.Entity.Question;
import com.example.antoangiaothong.atgt.Entity.User;
import com.example.antoangiaothong.atgt.Repository.ExamRepository;
import com.example.antoangiaothong.atgt.Repository.QuestionRepository;
import com.example.antoangiaothong.atgt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService{
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    @Autowired
    public ExamServiceImpl(ExamRepository examRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    @Transactional
    public Exam insertExam(Exam exam) {
        User owner= userRepository.findByUserId("admin");
        Exam exam1=new Exam();
        exam1.setOwner(owner);
        exam1.setName(exam.getName());
        exam1.setMaxTimes(exam.getMaxTimes());
        exam1.setTime(exam.getTime());

        examRepository.save(exam1);
        var i=1;
        Collection<Question> listQues=exam.getQuestions();
//        System.out.println(listQues.size());
        for (Question question:listQues
             ) {
//            question.setExam(exam);
            Question ques= new Question();
            ques.setExam(exam1);
            ques.setQuestion(question.getQuestion());
            ques.setAnswer(question.getAnswer());
            ques.setChoice1(question.getChoice1());
            ques.setChoice2(question.getChoice2());
            ques.setChoice3(question.getChoice3());
            ques.setChoice4(question.getChoice4());
            System.out.println(question);
            questionRepository.save(ques);
        }

//        System.out.println(exam.getQuestions().size());
        return exam;
    }

    @Override
    public Collection<Exam> getListExam() {
        Collection<Exam> listExams= examRepository.findAll();
        Collection<Exam> values=new ArrayList<>();
        for (var exam:listExams
             ) {
            Exam e= new Exam();
            e.setId(exam.getId());
            e.setName(exam.getName());
            e.setTime(exam.getTime());
            values.add(e);
        }
        return values;
    }

    @Override
    public Exam getExamById(int id) {
        Optional<Exam> exam= examRepository.findById(id);
        Exam e= new Exam();
        if(exam.isPresent()){
            e=exam.get();
        }
        return e;
    }
}
