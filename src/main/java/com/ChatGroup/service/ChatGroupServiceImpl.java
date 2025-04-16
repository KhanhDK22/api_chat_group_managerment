package com.ChatGroup.service;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.repository.ChatGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatGroupServiceImpl implements IChatGroupService {

    final
    ChatGroupRepository chatGroupRepository;

    public ChatGroupServiceImpl(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    @Override
    public List<ChatGroup> findAll() {
        try {
            return (List<ChatGroup>) chatGroupRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch chat groups", e);
        }

    }

    @Override
    public boolean delete(Long id) {
        try {
            if (chatGroupRepository.existsById(id)) {
                chatGroupRepository.deleteById(id); // Xoa nhom chat theo id
                return true; // Xoa thanh công
            } else {
                throw new RuntimeException("Chat group not found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete chat group with ID: " + id, e);
        }

    }

    @Override
    public ChatGroup findById(Long id) {

        try {
            return chatGroupRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Chat group not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to find chat group with ID: " + id, e);
        }

    }

    @Override
    public ChatGroup findChatGroupByName(String name) {

        try {
            return chatGroupRepository.findChatGroupByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find chat group by name", e);
        }


    }

    @Override
    public ChatGroup createChatGroup(ChatGroupCreationRequest request) {

        try {
            ChatGroup chatGroup = new ChatGroup();

            chatGroup.setName(request.getName());
            chatGroup.setCreator(request.getCreator());
            chatGroup.setMemberCount(request.getMemberCount());
            chatGroup.setPermission(request.getPermission());

            return chatGroupRepository.save(chatGroup);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create chat group", e);
        }

    }

    @Override
    public ChatGroup updateChatGroup(Long id, ChatGroupUpdateRequest request) {
        try {
            ChatGroup chatGroup = chatGroupRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Chat group with id not found: " + id));

            chatGroup.setName(request.getName());
            chatGroup.setCreator(request.getCreator());
            chatGroup.setMemberCount(request.getMemberCount());
            chatGroup.setPermission(request.getPermission());

            return chatGroupRepository.save(chatGroup);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update chat group with id" + id, e);
        }

    }
}
