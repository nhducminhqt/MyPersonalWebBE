package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.time.LocalDateTime;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {
    @Column(name="created_at")
    private LocalDateTime createAt;
    @Column(name="updated_at")
    private LocalDateTime updateAt;
    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updateAt = LocalDateTime.now();
        this.createAt = LocalDateTime.now();
    }


}
