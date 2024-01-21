package ru.vitte.online.helpdesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vitte.online.helpdesk.dto.*;
import ru.vitte.online.helpdesk.entity.FileEntity;
import ru.vitte.online.helpdesk.entity.RequestEntity;
import ru.vitte.online.helpdesk.entity.ResponseEntity;
import ru.vitte.online.helpdesk.entity.UserEntity;
import ru.vitte.online.helpdesk.entity.enums.Status;
import ru.vitte.online.helpdesk.repository.LogRepository;
import ru.vitte.online.helpdesk.repository.RequestRepository;
import ru.vitte.online.helpdesk.repository.ResponseRepository;
import ru.vitte.online.helpdesk.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ResponseRepository responseRepository;

    private final UserRepository userRepository;

    private final RequestRepository requestRepository;

    private final LogRepository logRepository;

    @Override
    public List<RequestDto> getAllRequestsByUserId(long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<RequestDto> result = new ArrayList<>();
            var response = requestRepository.findAllByUserId(userId);
            response.forEach(r -> {
                UserDto userDto = null;
                if (r.getEmployee() != null) {
                    var employee = userRepository.findById(r.getEmployee().getId());
                    userDto = employee
                            .map(userEntity -> new UserDto(userEntity.getFirstName(), userEntity.getLastName()))
                            .orElse(null);
                }
                var responses = responseRepository.findAllByRequestId(r.getId());
                LocalDateTime lastCommentTime = responses.stream()
                        .sorted()
                        .findFirst()
                        .get().getRequest().getCreationDate();
                int commentsCount = responses.size();

                result.add(new RequestDto(
                        r.getId(),
                        r.getStatus(),
                        r.getCreationDate(),
                        lastCommentTime,
                        commentsCount,
                        userDto));
            });

            return result;
        } else {
            throw new IllegalArgumentException("user with id  " + userId + " not found");
        }
    }

    @Override
    public long saveNewRequest(long userId, NewTaskDto newTaskDto) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setUser(user.get());
            requestEntity.setStatus(Status.NEW);
            var savedRequest = requestRepository.save(requestEntity);

            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setRequest(savedRequest);
            responseEntity.setText(newTaskDto.getCommentDto().getText());
            responseRepository.save(responseEntity);

            if (newTaskDto.getFileDto() != null) {
                FileEntity fileEntity = new FileEntity();
                fileEntity.setRequest(savedRequest);
                fileEntity.setName(newTaskDto.getFileDto().getName());
                fileEntity.setPath(newTaskDto.getFileDto().getPath());
            }

            return savedRequest.getId();
        } else {
            throw new IllegalArgumentException("user with id  " + userId + " not found");
        }
    }

    @Override
    public RequestDetailsDto getSingleRequestById(long userId, Long issueId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            var request = requestRepository.findById(issueId);
            if (request.isEmpty())
                throw new IllegalArgumentException("request with id  " + issueId + " not found");
            List<CommentDto> commentDtos = new ArrayList<>();

            var responses = responseRepository.findAllByRequestId(request.get().getId());
            responses.forEach(r -> {
                commentDtos.add(new CommentDto(
                        null, r.getText(), r.getRequest().getCreationDate()
                ));
            });
            return new RequestDetailsDto(
                    request.get().getId(),
                    request.get().getStatus(),
                    request.get().getCreationDate(),
                    commentDtos
            );
        } else {
            throw new IllegalArgumentException("user with id  " + userId + " not found");
        }
    }
}
