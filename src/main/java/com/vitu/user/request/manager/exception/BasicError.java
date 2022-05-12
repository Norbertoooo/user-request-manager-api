package com.vitu.user.request.manager.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.vitu.user.request.manager.util.Constants.DATE_TIME_PATTERN_BR;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicError {

    private int code;
    private String message;
    @JsonFormat(pattern = DATE_TIME_PATTERN_BR)
    private LocalDateTime date;

}
