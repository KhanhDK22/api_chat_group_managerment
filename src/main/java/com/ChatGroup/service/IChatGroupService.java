package com.ChatGroup.service;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;

import java.util.List;

public interface IChatGroupService {

    List<ChatGroup> findAll();

    boolean delete(Long id);

    ChatGroup findById(Long id);

    ChatGroup findChatGroupByName(String name);

    ChatGroup createChatGroup(ChatGroupCreationRequest request);

    ChatGroup updateChatGroup(Long id, ChatGroupUpdateRequest request);
}
