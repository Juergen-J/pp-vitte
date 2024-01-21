package ru.vitte.online.helpdesk.service;

import ru.vitte.online.helpdesk.dto.NewTaskDto;
import ru.vitte.online.helpdesk.dto.CommentDto;

import java.util.List;

public interface EmployeeService {
    List<NewTaskDto> getAllOpenRequests(long employeeId);

    NewTaskDto saveNewAnswer(long userId, Long issueId, CommentDto commentDto);
    NewTaskDto getSingleRequest(long employeeId, long issueID);
}
