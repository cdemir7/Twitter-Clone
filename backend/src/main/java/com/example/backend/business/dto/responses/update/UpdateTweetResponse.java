package com.example.backend.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTweetResponse {
    private int id;
    private int userId;
    private String text;
    private int commentNumber;
    private int likeNumber;
    private Date creationDate;
}
