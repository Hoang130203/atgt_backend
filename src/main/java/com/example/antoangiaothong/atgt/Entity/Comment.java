package com.example.antoangiaothong.atgt.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CookieValue;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
@Entity
public class Comment {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "content",columnDefinition = "nvarchar(max)")
    private String content;

    @Column(name = "time")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;
}
