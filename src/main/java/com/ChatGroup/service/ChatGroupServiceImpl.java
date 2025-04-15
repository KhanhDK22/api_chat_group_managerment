package com.ChatGroup.service;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.repository.ChatGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatGroupServiceImpl implements IChatGroupService{

    @Autowired
    ChatGroupRepository chatGroupRepository;

    @Override
    public List<ChatGroup> findAll() {
        return (List<ChatGroup>) chatGroupRepository.findAll();
    }

    @Override
    public void save(ChatGroup chatGroup) {
        chatGroupRepository.save(chatGroup);
    }

    @Override
    public void delete(@Param("id") Long id) {
        chatGroupRepository.deleteById(id);
    }

    @Override
    public ChatGroup findById(@Param("id") Long id) {
        return chatGroupRepository.findById(id).get();
    }

    @Override
    public ChatGroup findChatGroupByName(@Param("name") String name) {
        return chatGroupRepository.findChatGroupByName(name);
    }

    @Override
    public ChatGroup createChatGroup(ChatGroupCreationRequest request) {

        ChatGroup chatGroup = new ChatGroup();

//        if (chatGroupRepository.existsByName(request.getName()))
//            throw new RuntimeException("Name already exists");

        chatGroup.setName(request.getName());
        chatGroup.setCreator(request.getCreator());
        chatGroup.setMemberCount(request.getMemberCount());
        chatGroup.setPermission(request.getPermission());

        return chatGroupRepository.save(chatGroup);
    }

    @Override
    public ChatGroup updateChatGroup(@Param("id") Long id, ChatGroupUpdateRequest request) {
        ChatGroup chatGroup = chatGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chat group with id not found: " + id));

        chatGroup.setName(request.getName());
        chatGroup.setCreator(request.getCreator());
        chatGroup.setMemberCount(request.getMemberCount());
        chatGroup.setPermission(request.getPermission());

        return chatGroupRepository.save(chatGroup);
    }


}
