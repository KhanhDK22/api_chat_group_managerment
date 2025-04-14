package com.ChatGroup.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "chat_group")
public class ChatGroupCreationRequest {

    @Column(name = "chat_group_name")
    @Size(min = 3, message = "Group name must be 3 characters or more")
    private String name;

    @Column(name = "chat_group_creator")
    private String creator;

    @Column(name = "chat_group_memberCount")
    private Integer memberCount;

    @Column(name = "chat_group_permission")
    private String permission;

}
