package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.ClubDto;
import com.padel.scheduler.model.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FieldMapper.class})
public interface ClubMapper {

    @Mapping(source = "fieldDtos", target = "fields")
    Club clubDtoToClub(ClubDto clubDto);

    @Mapping(source = "fields", target = "fieldDtos")
    ClubDto clubToClubDto(Club club);

}
