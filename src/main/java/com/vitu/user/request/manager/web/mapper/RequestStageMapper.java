package com.vitu.user.request.manager.web.mapper;

import com.vitu.user.request.manager.domain.RequestStage;
import com.vitu.user.request.manager.web.dto.RequestStageDto;
import org.modelmapper.ModelMapper;

import java.util.List;

public class RequestStageMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static RequestStage toDomain(RequestStageDto requestStageDto) {
        return modelMapper.map(requestStageDto, RequestStage.class);
    }

    public static List<RequestStage> toDomain(List<RequestStageDto> requestStageDtos) {
        return requestStageDtos.stream().map(RequestStageMapper::toDomain).toList();
    }

    public static RequestStageDto toDto(RequestStage requestStage) {
        return modelMapper.map(requestStage, RequestStageDto.class);
    }

    public static List<RequestStageDto> toDto(List<RequestStage> requestStages) {
        return requestStages.stream().map(RequestStageMapper::toDto).toList();
    }
}
