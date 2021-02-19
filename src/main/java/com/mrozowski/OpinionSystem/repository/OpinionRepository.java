package com.mrozowski.OpinionSystem.repository;

import com.mrozowski.OpinionSystem.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
