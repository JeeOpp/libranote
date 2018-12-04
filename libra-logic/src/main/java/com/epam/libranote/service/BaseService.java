package com.epam.libranote.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    void insert(T entity);
    List<T> findAll();
    Optional<T> findById(Long id);
    void update(T entity);
    void deleteById(Long id);

}
