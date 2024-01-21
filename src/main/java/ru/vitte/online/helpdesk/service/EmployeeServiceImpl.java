package ru.vitte.online.helpdesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vitte.online.helpdesk.dto.NewTaskDto;
import ru.vitte.online.helpdesk.dto.CommentDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<NewTaskDto> getAllOpenRequests(long employeeId) {
        return null;
    }

    @Override
    public NewTaskDto saveNewAnswer(long userId, Long issueId, CommentDto commentDto) {
        return null;
    }

    @Override
    public NewTaskDto getSingleRequest(long employeeId, long issueID) {
        return null;
    }
}
