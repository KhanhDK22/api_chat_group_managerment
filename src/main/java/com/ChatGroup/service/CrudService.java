package com.ChatGroup.service;

import java.util.List;

public interface CrudService <E>{
    List<E> findAll();

    void save(E e);

    void delete(Long id);

    E findById(Long id);

    E findChatGroupByName(String name);
}
