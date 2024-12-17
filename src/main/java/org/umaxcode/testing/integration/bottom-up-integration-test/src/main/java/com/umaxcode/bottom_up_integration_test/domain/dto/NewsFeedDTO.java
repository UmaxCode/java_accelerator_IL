package com.umaxcode.bottom_up_integration_test.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsFeedDTO {

    private String title;
    private String content;
    private LocalDateTime timestamp;
}
