package com.acheron.offlinecommunication.repository;

import com.acheron.offlinecommunication.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ActorRepository extends JpaRepository<Actor , Integer> {
}
