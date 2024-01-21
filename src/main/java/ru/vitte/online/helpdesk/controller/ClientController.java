package ru.vitte.online.helpdesk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vitte.online.helpdesk.dto.NewTaskDto;
import ru.vitte.online.helpdesk.dto.RequestDetailsDto;
import ru.vitte.online.helpdesk.dto.RequestDto;
import ru.vitte.online.helpdesk.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hdesk/client/")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("")
    public List<RequestDto> getAllRequests() {
//        todo add secure service and get user id from the token, use default userId
        long userId = 1L;
        return clientService.getAllRequestsByUserId(userId);
    }

    @PostMapping("new-issue")
    public Long postNewIssue(@RequestBody NewTaskDto newTaskDto) {
        //        todo add secure service and get user id from the token, use default userId
        long userId = 1L;
        return clientService.saveNewRequest(userId, newTaskDto);
    }

    @GetMapping("issues/{issueID}")
    public RequestDetailsDto getSingleRequestById(@PathVariable("issueID") Long issueID) {
        //        todo add secure service and get user id from the token, use default userId
        long userId = 1L;
        return clientService.getSingleRequestById(userId, issueID);
    }
}
