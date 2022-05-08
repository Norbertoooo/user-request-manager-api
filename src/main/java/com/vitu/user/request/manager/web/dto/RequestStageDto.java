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
@AllArgsConstructor
@NoArgsConstructor
public class RequestStageDto implements Serializable {
    private Long id;
    private String description;
    private LocalDateTime realizationDate;
    private RequestState state;
    private RequestDto request;
    private UserDto user;
}
