package com.acheron.offlinecommunication.repository;

import com.acheron.offlinecommunication.model.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditorRepository extends JpaRepository<Auditor, Integer> {
}
