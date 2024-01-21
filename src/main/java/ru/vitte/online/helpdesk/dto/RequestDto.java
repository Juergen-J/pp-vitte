package ru.vitte.online.helpdesk.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import ru.vitte.online.helpdesk.entity.UserEntity;
import ru.vitte.online.helpdesk.entity.enums.Status;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDto {

    private Long id;

    private Status status;

    private LocalDateTime creationDate;

    private LocalDateTime lastCommentDate;

    private int commentsCount;

    private UserDto employee;
}
