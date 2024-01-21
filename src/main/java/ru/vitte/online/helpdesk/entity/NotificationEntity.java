package ru.vitte.online.helpdesk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitte.online.helpdesk.entity.enums.Type;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
