package ru.vitte.online.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vitte.online.helpdesk.entity.ResponseEntity;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<ResponseEntity, Long> {

    List<ResponseEntity> findAllByRequestId(long requestId);

}
