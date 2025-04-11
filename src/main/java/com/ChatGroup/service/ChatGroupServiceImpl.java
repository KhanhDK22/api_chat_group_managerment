package com.ChatGroup.service;

import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.repository.ChatGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void delete(Long id) {
        chatGroupRepository.deleteById(id);
    }

    @Override
    public ChatGroup findById(Long id) {
        return chatGroupRepository.findById(id).get();
    }

    public ChatGroup findChatGroupByName(String name) {
        return chatGroupRepository.findChatGroupByName(name);
    }
}
