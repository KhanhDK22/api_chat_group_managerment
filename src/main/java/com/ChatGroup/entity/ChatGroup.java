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
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String creator;

    private Integer memberCount;

    private String permission;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss yyyy-MM-dd ")
    private LocalDateTime createdAt;

    @PrePersist
    protected void currentCreationDate() {
        this.createdAt = LocalDateTime.now();
    }

}
