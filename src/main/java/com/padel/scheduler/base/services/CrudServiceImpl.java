package com.padel.scheduler.base.services;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.exceptions.NotFoundException;
import com.padel.scheduler.base.mappers.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class CrudServiceImpl<T, M> implements CrudService<T> {

    private final JpaRepository<M, Integer> repository;
    protected final BaseMapper<T, M> mapper;

    @Override
    public T save(T dto) {
        return mapper.modelToDto(repository.save(mapper.dtoToModel(dto)));
    }

    @Override
    public Page<T> list(PageableRequestDto pageableRequestDto) {
        return new PageImpl(repository.findAll(getPageable(pageableRequestDto)).getContent().stream()
          .map(mapper::modelToDto)
          .collect(Collectors.toList())
        );
    }

    @Override
    public T findById(Integer id) {
        return repository.findById(id)
          .map(mapper::modelToDto)
          .orElseThrow(() -> new NotFoundException("Not found for provided id: " + id));
    }
}
