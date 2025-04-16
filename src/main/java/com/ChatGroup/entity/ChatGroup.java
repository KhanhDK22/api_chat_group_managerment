package com.ChatGroup.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_group")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss yyyy-MM-dd ")
    //format lai dinh dang ngay
    private LocalDateTime createdAt;

    @PrePersist
    protected void currentCreationDate() {
        this.createdAt = LocalDateTime.now();
    }
    //Su dung de tao ngay tu dong

}
