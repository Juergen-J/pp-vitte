package ru.vitte.online.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vitte.online.helpdesk.entity.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
