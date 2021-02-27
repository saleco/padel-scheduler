package com.padel.scheduler.base.mappers;

public interface BaseMapper<T, M> {
    T modelToDto(M model);
    M dtoToModel(T dto);

}
