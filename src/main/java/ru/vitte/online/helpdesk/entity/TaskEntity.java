package ru.vitte.online.helpdesk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitte.online.helpdesk.entity.enums.Status;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private RequestEntity request;

    private String description;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity assignedTo;


}
