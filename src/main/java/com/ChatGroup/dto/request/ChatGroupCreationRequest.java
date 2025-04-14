package com.ChatGroup.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ChatGroupCreationRequest {
    @Size(min = 3, message = "Group name must be 3 characters or more")
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;

}
