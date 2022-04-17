package com.example.apirestone.controller.mappers;

import com.example.apirestone.controller.dtos.response.TopicPostResponseDTO;
import com.example.apirestone.model.Topic;
import com.example.apirestone.controller.dtos.request.TopicPostReqDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    Topic toDomain(TopicPostReqDTO topicPostReqBody);

    TopicPostResponseDTO fromDomain(Topic topic);

}
