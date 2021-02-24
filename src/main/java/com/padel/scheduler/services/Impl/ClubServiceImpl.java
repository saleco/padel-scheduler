package com.padel.scheduler.services.Impl;

import com.padel.scheduler.converters.ClubMapper;
import com.padel.scheduler.dtos.ClubDto;
import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.model.Club;
import com.padel.scheduler.repositories.ClubRepository;
import com.padel.scheduler.services.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    @Override
    public ClubDto save(ClubDto clubDto) {
        return clubMapper.clubToClubDto(clubRepository.save(clubMapper.clubDtoToClub(clubDto)));
    }

    @Override
    public List<ClubDto> list() {
        return StreamSupport.stream(clubRepository.findAll().spliterator(), true)
                .map(clubMapper::clubToClubDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClubDto findById(Integer id) {
        return clubRepository.findById(id)
                .map(clubMapper::clubToClubDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
