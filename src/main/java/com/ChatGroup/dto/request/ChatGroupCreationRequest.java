package com.ChatGroup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ChatGroupCreationRequest {
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;

    private LocalDate createdAt;
}
