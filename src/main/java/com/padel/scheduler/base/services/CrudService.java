package com.padel.scheduler.base.services;

import com.padel.scheduler.base.dto.PageableRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {

    default Pageable getPageable(PageableRequestDto pageableRequestDto) {
        return PageRequest.of(pageableRequestDto.getPage(), pageableRequestDto.getSize());
    }

    T save(T dto);
    Page<T> list(PageableRequestDto pageableRequestDto);
    T findById(Integer id);

}
