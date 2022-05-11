package com.vitu.user.request.manager.web.mapper;

import com.vitu.user.request.manager.domain.Request;
import com.vitu.user.request.manager.web.dto.RequestDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class RequestMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Request toDomain(RequestDto requestDto) {
        return modelMapper.map(requestDto, Request.class);
    }

    public List<Request> toDomain(List<RequestDto> requestDtos) {
        return requestDtos.stream().map(RequestMapper::toDomain).collect(Collectors.toList());
    }

    public static RequestDto toDto(Request request) {
        return modelMapper.map(request, RequestDto.class);
    }

    public static List<RequestDto> toDto(List<Request> requests) {
        return requests.stream().map(RequestMapper::toDto).collect(Collectors.toList());
    }

}
