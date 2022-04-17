package com.example.apirestone.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Data
public class TopicDto {

    private String title;
    private String message;
    private LocalDateTime creationDate;

}
