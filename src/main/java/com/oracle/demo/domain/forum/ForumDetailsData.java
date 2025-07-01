package com.oracle.demo.domain.forum;

import java.time.LocalDateTime;

public record ForumDetailsData(
           Long id,
           String title,
           String message,
           LocalDateTime createDate,
           String author,
           Boolean active,
           String course
        ){

    public ForumDetailsData(Forum data) {
        this(data.getId(),data.getTitle(), data.getMessage(), data.getCreateData(), data.getAuthor(), data.getActive(), data.getCourse());
    }
}
