package ru.vitte.online.helpdesk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vitte.online.helpdesk.dto.NewTaskDto;
import ru.vitte.online.helpdesk.dto.CommentDto;
import ru.vitte.online.helpdesk.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/v1/hdesk/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("issues")
    public List<NewTaskDto> getAllOpenRequests() {
        //        todo add secure service and get user id from the token, use default employeeId and check role
        long employeeId = 1L;
        return employeeService.getAllOpenRequests(employeeId);
    }

    @GetMapping("issues/{issueId}")
    public NewTaskDto getSingleRequest(@RequestParam Long issueId) {
        //        todo add secure service and get user id from the token, use default employeeId and check role
        long employeeId = 1L;
        return employeeService.getSingleRequest(employeeId, issueId);
    }

    @PostMapping("issues/{issueId}")
    public NewTaskDto postAnswer(@RequestParam Long issueId, @RequestBody CommentDto commentDto) {
        //        todo add secure service and get user id from the token, use default userId
        long userId = 1L;
        return employeeService.saveNewAnswer(userId, issueId, commentDto);
    }
}
