package com.oracle.demo.domain.forum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "forum")
@Entity(name = "Forum")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime createData;
    private Boolean active;
    private String author;
    private String course;


    public Forum(ForumData data) {
        this.title = data.title();
        this.author = data.author();
        this.message = data.message();
        this.createData = data.createDate();
        this.course = data.course();
        this.active = true;
    }

    public void delete() {
        this.active = false;
    }

}
