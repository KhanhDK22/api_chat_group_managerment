package com.ChatGroup.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_group")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_group_id")
    private Long id;

    @Column(name = "chat_group_name")
    private String name;

    @Column(name = "chat_group_creator")
    private String creator;

    @Column(name = "chat_group_memberCount")
    private Integer memberCount;

    @Column(name = "permission")
    private String permission;

    @Column(name = "createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss yyyy-MM-dd ")
    //format lai dinh dang ngay
    private LocalDateTime createdAt;

    @PrePersist
    protected void currentCreationDate() {
        this.createdAt = LocalDateTime.now();
    }
    //Su dung de tao ngay tu dong

}
