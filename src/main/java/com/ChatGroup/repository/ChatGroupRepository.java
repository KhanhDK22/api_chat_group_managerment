package com.ChatGroup.repository;

import com.ChatGroup.entity.ChatGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional //Dam bao toan ven du lieu
public interface ChatGroupRepository extends CrudRepository<ChatGroup, Long> {

    @Query(value = "SELECT * FROM chat_group WHERE chat_group_name = :name", nativeQuery = true)
    ChatGroup findChatGroupByName(@Param("name") String name);

//    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM chat_group WHERE chat_group_name = :name", nativeQuery = true)
//    boolean existsByName(@Param("name") String name);
}

//@Param dung de lien ket tham so trong method voi bien trong cau truy van JPQL hoặc native SQL