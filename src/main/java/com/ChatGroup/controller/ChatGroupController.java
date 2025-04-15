package com.ChatGroup.controller;

import com.ChatGroup.dto.request.ChatGroupCreationRequest;
import com.ChatGroup.dto.request.ChatGroupUpdateRequest;
import com.ChatGroup.entity.ChatGroup;
import com.ChatGroup.service.IChatGroupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/chat")
public class ChatGroupController {

    final
    IChatGroupService iChatGroupService;

    public ChatGroupController(IChatGroupService iChatGroupService) {
        this.iChatGroupService = iChatGroupService;
    }

    // Hien thi all group chat
    @GetMapping("/show-all-chat-group")
    public ResponseEntity<Map<String, Object>> findAll() {

        List<ChatGroup> chatGroup = iChatGroupService.findAll();

        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.OK.value());
        response.put("message", chatGroup.isEmpty() ? "No chat groups available." : "Chat groups retrieved successfully.");
        response.put("data", chatGroup);

        return ResponseEntity.ok(response);
    }

    // Hien thi thong tin 1 group chat bang id
    @GetMapping("/show-chat-group-by-id/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {

        ChatGroup chatGroup = iChatGroupService.findById(id);

        // Nếu không tìm thấy, ném RuntimeException với thông điệp lỗi
        if (chatGroup == null) {
            throw new RuntimeException("Chat group with ID " + id + " not found.");
        }

        // Tạo phản hồi nếu tìm thấy
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value()); // Trạng thái HTTP: 200
        response.put("message", "Chat group found successfully");
        response.put("data", chatGroup);

        return ResponseEntity.ok(response);// Luôn trả về HTTP 200 cho client
    }

    // Hien thi thong tin 1 group chat bang name
    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<Map<String, Object>> findChatGroupByName(@PathVariable String name) {

        ChatGroup chatGroup = iChatGroupService.findChatGroupByName(name);

        // Nếu không tìm thấy, ném RuntimeException với thông điệp lỗi
        if (chatGroup == null) {
            throw new RuntimeException("Chat group with name " + name + " not found.");
        }

        // Tạo phản hồi nếu tìm thấy
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value()); // Trạng thái HTTP: 200
        response.put("message", "Chat group found successfully");
        response.put("data", chatGroup);

        return ResponseEntity.ok(response);
    }

    // Tao moi group chat
    @PostMapping("/create-chat-group")
    public ResponseEntity<Map<String, Object>> saveChatGroup(@RequestBody @Valid ChatGroupCreationRequest request) {

        Map<String, Object> response = new HashMap<>();

        ChatGroup createdChatGroup = iChatGroupService.createChatGroup(request);

        // Nếu tạo mới thành công
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Chat group created successfully.");
        response.put("data", createdChatGroup);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    // Update group chat theo id
    @PutMapping("/update-chat-group-by-id/{id}")
    public ResponseEntity<Map<String, Object>> updateChatGroup(@PathVariable Long id, @RequestBody @Valid ChatGroupUpdateRequest request) {

        Map<String, Object> response = new HashMap<>();

        ChatGroup updatedChatGroup = iChatGroupService.updateChatGroup(id, request);

        // Kiểm tra kết quả cập nhật
        if (updatedChatGroup != null) {
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Chat group updated successfully.");
            response.put("data", updatedChatGroup);
        } else {
            throw new RuntimeException("Chat group with ID " + id + " not found.");
        }

        return ResponseEntity.ok(response);
    }

    // Xoa group chat theo id
    @DeleteMapping("/delete-chat-group-by-id/{id}")
    public ResponseEntity<Map<String, Object>> deleteChatGroup(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        
        boolean isDeleted = iChatGroupService.delete(id);

        // Kiểm tra kết quả xóa
        if (isDeleted) {
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Chat group deleted successfully.");
            response.put("data", null);
        } else {
            throw new RuntimeException("Chat group with ID " + id + " not found.");
        }

        return ResponseEntity.ok(response);
    }

}
