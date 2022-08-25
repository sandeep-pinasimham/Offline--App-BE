package com.acheron.offlinecommunication.service;

import com.acheron.offlinecommunication.exception.InvalidIdException;
import com.acheron.offlinecommunication.model.Auditor;
import com.acheron.offlinecommunication.model.Request;
import com.acheron.offlinecommunication.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements  IRequestService {

    private RequestRepository requestRepository;
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    @Override
    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    @Override
    public void updateRequest(Request request) {
        Request request1 = requestRepository.findById(request.getRequestId()).get();
//        request1.setAuditor(request.getAuditor());
        request1.setSeriesReleaseYear(request.getSeriesReleaseYear());
        request1.setSeriesName(request.getSeriesName());
        request1.setEpisodeNumber(request.getEpisodeNumber());
        request1.setRating(request.getRating());
        request1.setEpisodeDescription(request.getEpisodeDescription());
        request1.setGenre(request.getGenre());
        request1.setLanguage(request.getLanguage());
        request1.setDirectorName(request.getDirectorName());
        request1.setProducerName(request.getProducerName());
        request1.setStatus(request.getStatus());
        request1.setActors(request.getActors());




        requestRepository.save(request1);


    }

    @Override
    public void deleteRequest(int requestId) {

        requestRepository.deleteById(requestId);




    }

    @Override
    public Request getByRequestId(int requestId) throws InvalidIdException {
        return requestRepository.findById(requestId).get();
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestsByAuditorId(String auditorName) {
        return requestRepository.getAllRequestsByAuditorId(auditorName);
    }
//

    @Override
    public List<Request> getAllRequestsForManager(String manager) {
        return requestRepository.getAllRequestsForManager(manager);
    }




}
