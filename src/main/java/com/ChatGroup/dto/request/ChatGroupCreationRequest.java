package com.ChatGroup.dto.request;

import lombok.*;

@Getter
@Setter
public class ChatGroupCreationRequest {

    @NonNull
    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;

}
