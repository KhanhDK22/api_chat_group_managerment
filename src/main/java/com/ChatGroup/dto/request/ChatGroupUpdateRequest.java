package com.ChatGroup.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class ChatGroupUpdateRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;
}
