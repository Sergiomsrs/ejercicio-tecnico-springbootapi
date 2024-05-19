package org.ptecnica.pruebatecspringboot.persistence.repository;

import org.ptecnica.pruebatecspringboot.persistence.entity.UserInteractionLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionRepository extends JpaRepository<UserInteractionLog, Long> {


    Page<UserInteractionLog> findByUsername(Pageable pageable, String username);
}
