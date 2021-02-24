package com.padel.scheduler.services;

import com.padel.scheduler.dtos.ClubDto;

import java.util.List;

public interface ClubService {

    ClubDto save(ClubDto club);
    List<ClubDto> list();
    ClubDto findById(Integer id);
}
