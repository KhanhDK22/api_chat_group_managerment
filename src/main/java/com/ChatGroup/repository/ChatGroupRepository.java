package com.ChatGroup.repository;

import com.ChatGroup.entity.ChatGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ChatGroupRepository extends CrudRepository<ChatGroup, Long> {

    @Query("SELECT n FROM ChatGroup n WHERE n.name = :name")
    ChatGroup findChatGroupByName(String name);
}
