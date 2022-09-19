package com.example.testcoin.mapper;

import com.example.testcoin.dto.DescriptionDto;
import com.example.testcoin.model.Description;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DescriptionMapping {
    public DescriptionDto toDto(Description description);
    public Description toEntity(DescriptionDto descriptionDto);
}
