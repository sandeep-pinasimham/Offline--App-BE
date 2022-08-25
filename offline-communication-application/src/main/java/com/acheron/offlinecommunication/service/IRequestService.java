package com.acheron.offlinecommunication.service;

import com.acheron.offlinecommunication.exception.InvalidIdException;
import com.acheron.offlinecommunication.model.Auditor;
import com.acheron.offlinecommunication.model.Request;

import java.util.List;
import java.util.Set;

public interface IRequestService {

    void addRequest(Request request);
    void updateRequest(Request request);
    void deleteRequest(int requestId);
    Request getByRequestId(int requestId) throws InvalidIdException;
    List<Request> getAll();
    List<Request> getAllRequestsByAuditorId(String auditorName);
    List<Request> getAllRequestsForManager(String manager);
}
