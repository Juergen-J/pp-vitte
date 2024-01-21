package ru.vitte.online.helpdesk.service;

import ru.vitte.online.helpdesk.dto.NewTaskDto;
import ru.vitte.online.helpdesk.dto.RequestDetailsDto;
import ru.vitte.online.helpdesk.dto.RequestDto;

import java.util.List;

public interface ClientService {

    List<RequestDto> getAllRequestsByUserId(long userId);

    long saveNewRequest(long userId, NewTaskDto newTaskDto);

    RequestDetailsDto getSingleRequestById(long userId, Long issueID);
}
