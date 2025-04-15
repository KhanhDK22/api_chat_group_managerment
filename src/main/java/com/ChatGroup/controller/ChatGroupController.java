package com.ChatGroup.controller;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.service.IChatGroupService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/chat")
public class ChatGroupController {

    final
    IChatGroupService iChatGroupService;

    public ChatGroupController(IChatGroupService iChatGroupService) {
        this.iChatGroupService = iChatGroupService;
    }

    //Hien thi tat ca nhom chat
    @GetMapping("/show-all-chat-group")
    public List<ChatGroup> findAll() {
        return iChatGroupService.findAll();
    }

    //Hien thi thong tin 1 nhom chat bang id
    @GetMapping("/show-chat-group-by-id/{id}")
    public ChatGroup findById(@PathVariable("id") Long id) {
        return iChatGroupService.findById(id);
    }

    //Hien thi thong tin 1 nhom chat bang name
    @GetMapping("/find-by-name/{name}")
    public ChatGroup findChatGroupByName(@PathVariable("name") String name) {
        return iChatGroupService.findChatGroupByName(name);
    }

    //Tao moi nhom chat, Dung DTO ChatGroupCreationRequest de gom du lieu gui len.
//    @PostMapping("/create-chat-group")
//    public ChatGroup saveChatGroup( @RequestBody ChatGroupCreationRequest request) {
//        //System.out.printf("Saving chat group %s\n", request);
//
//        ChatGroup chatGroup = new ChatGroup();
//
//        chatGroup.setName(request.getName());
//        chatGroup.setCreator(request.getCreator());
//        chatGroup.setMemberCount(request.getMemberCount());
//        chatGroup.setPermission(request.getPermission());
//        chatGroup.setCreatedAt(request.getCreatedAt());
//
//        chatGroupService.save(chatGroup);
//        return chatGroup;
//    }

    // Tao moi nhom chat
    @PostMapping("/create-chat-group")
    public ChatGroup saveChatGroup(@RequestBody @Valid ChatGroupCreationRequest request) {
        return iChatGroupService.createChatGroup(request);
    }


    //Cap nhat thong tin nhom chat qua id, Dung DTO ChatGroupUpdateRequest de gom du lieu gui len.
//    @PutMapping("/update-chat-group-by-id/{id}")
//    public ChatGroup updateChatGroup(@PathVariable Long id, @RequestBody ChatGroupUpdateRequest request) {
//        System.out.printf("Updating chat group %s\n", request);
//
//        ChatGroup chatGroup = chatGroupService.findById(id);
//
//        chatGroup.setName(request.getName());
//        chatGroup.setCreator(request.getCreator());
//        chatGroup.setMemberCount(request.getMemberCount());
//        chatGroup.setPermission(request.getPermission());
//
//        chatGroupService.save(chatGroup);
//        return chatGroup;
//    }

    @PutMapping("/update-chat-group-by-id/{id}")
    public ChatGroup updateChatGroup(@PathVariable("id") Long id, @RequestBody @Valid ChatGroupUpdateRequest request) {
        return iChatGroupService.updateChatGroup(id, request);
    }

    //Xoa nhom chat theo id
    @DeleteMapping("/delete-chat-group-by-id/{id}")
    public void deleteChatGroup(@PathVariable("id") Long id) {
        iChatGroupService.delete(id);
    }
}
