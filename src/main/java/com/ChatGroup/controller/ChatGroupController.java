package com.ChatGroup.controller;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.service.ChatGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/chat")
public class ChatGroupController {
    @Autowired
    ChatGroupServiceImpl chatGroupService;

    //Hien thi tat ca nhom chat
    @GetMapping
    public List<ChatGroup> findAll() {
        return chatGroupService.findAll();
    }

    //Hien thi thong tin 1 nhom chat bang id
    @GetMapping("/{id}")
    public ChatGroup findById(@PathVariable Long id) {
        return chatGroupService.findById(id);
    }

    //Tao moi nhom chat, Dung DTO ChatGroupCreationRequest de gom du lieu gui len.
    @PostMapping
    public ChatGroup saveChatGroup( @RequestBody ChatGroupCreationRequest request) {
        //System.out.printf("Saving chat group %s\n", request);

        ChatGroup chatGroup = new ChatGroup();

        chatGroup.setName(request.getName());
        chatGroup.setCreator(request.getCreator());
        chatGroup.setMemberCount(request.getMemberCount());
        chatGroup.setPermission(request.getPermission());
        chatGroup.setCreatedAt(request.getCreatedAt());

        chatGroupService.save(chatGroup);
        return chatGroup;
    }

    //Cap nhat thong tin nhom chat qua id, Dung DTO ChatGroupUpdateRequest de gom du lieu gui len.
    @PutMapping("/{id}")
    public ChatGroup updateChatGroup(@PathVariable Long id, @RequestBody ChatGroupUpdateRequest request) {
//        System.out.printf("Updating chat group %s\n", request);

        ChatGroup chatGroup = chatGroupService.findById(id);

        chatGroup.setName(request.getName());
        chatGroup.setCreator(request.getCreator());
        chatGroup.setMemberCount(request.getMemberCount());
        chatGroup.setPermission(request.getPermission());

        chatGroupService.save(chatGroup);
        return chatGroup;
    }

    //Xoa nhom chat
    @DeleteMapping("/{id}")
    public void deleteChatGroup(@PathVariable Long id) {
        chatGroupService.delete(id);
    }
}
