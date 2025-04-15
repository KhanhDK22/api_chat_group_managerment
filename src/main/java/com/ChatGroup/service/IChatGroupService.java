package com.ChatGroup.service;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import org.springframework.data.repository.query.Param;

public interface IChatGroupService extends CrudService<ChatGroup> {

    ChatGroup findChatGroupByName(@Param("name") String name);

    ChatGroup createChatGroup(ChatGroupCreationRequest request);

    ChatGroup updateChatGroup(@Param("id") Long id, ChatGroupUpdateRequest request);
}
