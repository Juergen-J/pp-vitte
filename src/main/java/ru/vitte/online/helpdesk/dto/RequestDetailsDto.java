package ru.vitte.online.helpdesk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vitte.online.helpdesk.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDetailsDto {

    private Long id;

    private Status status;

    private LocalDateTime creationDate;

    private List<CommentDto> comments;
}
