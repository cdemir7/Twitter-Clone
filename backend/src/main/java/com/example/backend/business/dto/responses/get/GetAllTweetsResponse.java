package com.example.backend.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTweetsResponse {
    private int id;
    private int userId;
    private String text;
    private int commentNumber;
    private int likeNumber;
    private LocalDateTime creationDate;
}
