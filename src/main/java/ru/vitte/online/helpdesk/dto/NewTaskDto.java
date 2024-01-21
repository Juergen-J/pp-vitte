package ru.vitte.online.helpdesk.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewTaskDto {

    CommentDto commentDto;

    FileDto fileDto;
}
