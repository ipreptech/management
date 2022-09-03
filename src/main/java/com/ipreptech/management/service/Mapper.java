package com.ipreptech.management.service;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<M, E> {

    public abstract E modelToEntity(M m);

    public abstract M entityToModel(E e);

    List<M> mapEntityListToModelList(List<E> entityList) {
        return entityList.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    List<E> mapModelListToEntityList(List<M> modelList) {
        return modelList.stream().map(this::modelToEntity).collect(Collectors.toList());
    }
}
