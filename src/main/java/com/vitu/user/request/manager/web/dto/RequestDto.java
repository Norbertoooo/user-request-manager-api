package com.vitu.user.request.manager.web.dto;

import com.vitu.user.request.manager.domain.RequestState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto implements Serializable {
    private Long id;
    private String subject;
    private String description;
    private LocalDateTime creationDate;
    private RequestState state;
    private UserDto user;
}
