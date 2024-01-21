package ru.vitte.online.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vitte.online.helpdesk.entity.RequestEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

    List<RequestEntity> findAllByUserId(long userId);

    Optional<RequestEntity> findById(long id);
}
