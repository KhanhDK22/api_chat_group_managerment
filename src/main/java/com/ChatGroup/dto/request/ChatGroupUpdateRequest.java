package com.ChatGroup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatGroupUpdateRequest {
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;
}
