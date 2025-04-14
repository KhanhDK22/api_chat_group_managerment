package com.ChatGroup.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatGroupUpdateRequest {

    @Size(min = 3, message = "Group name must be 3 characters or more")
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;
}
