package com.example.antoangiaothong.atgt.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
class ResultId implements Serializable{
    @Column(name = "user_id")
    private String userId;

    @Column(name = "exam_id")
    private int examId;
}

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "result")
public class Result {
    @EmbeddedId
    private ResultId resultId;

    @Column(name = "number_correct")
    private int numberCorrect;

    @Column(name = "total_question")
    private int totalQuestion;

    @Column(name = "time")
    private int time;

    @Column(name = "number_of_times_done")
    private int numberOfTimes;
}
