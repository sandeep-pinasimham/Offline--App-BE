package com.acheron.offlinecommunication.repository;

import com.acheron.offlinecommunication.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Query(value = "select r from Request r where r.auditor.auditorName=:auditorName")
    List<Request> getAllRequestsByAuditorId(String auditorName);

    @Query(value = "select r from Request r where r.createdBy=:manager")
    List<Request> getAllRequestsForManager(String manager);
}
