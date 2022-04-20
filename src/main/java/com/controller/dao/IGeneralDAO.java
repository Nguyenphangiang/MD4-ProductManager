package com.controller.dao;

import java.util.List;

public interface IGeneralDAO<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void removeById(Long id);
}
