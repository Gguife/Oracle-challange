package com.oracle.demo.domain.forum;

import java.time.LocalDateTime;

public record ForumData(
        String title,
        String message,
        LocalDateTime createDate,
        String author,
        String course
    ) {
}
