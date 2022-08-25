package com.acheron.offlinecommunication.controller;


import com.acheron.offlinecommunication.model.Actor;
import com.acheron.offlinecommunication.model.Auditor;
import com.acheron.offlinecommunication.model.Request;
import com.acheron.offlinecommunication.repository.AuditorRepository;
import com.acheron.offlinecommunication.service.ActorServiceImpl;
import com.acheron.offlinecommunication.service.IActorService;
import com.acheron.offlinecommunication.service.IAuditorService;
import com.acheron.offlinecommunication.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RequestController {
    private IRequestService iRequestService;
    private IAuditorService iAuditorService;
    private IActorService iActorService;
    private AuditorRepository auditorRepository;

    @Autowired
    public void setiActorService(IActorService iActorService) {
        this.iActorService = iActorService;
    }

    @Autowired
    public void setAuditorRepository(AuditorRepository auditorRepository) {
        this.auditorRepository = auditorRepository;
    }

    @Autowired
    public void setiAuditorService(IAuditorService iAuditorService) {
        this.iAuditorService = iAuditorService;
    }

    @Autowired
    public void setiRequestService(IRequestService iRequestService) {
        this.iRequestService = iRequestService;
    }


    @GetMapping("/greet")
    public ResponseEntity<String> sayHello(){
        String msg = "Welcome to Offline Communication App";
        //For creating custom headers we need to create instance for HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        // Creating Custom Headers here
        headers.add("desc","Offline Application");
        //Below we are creating ResponseEntity object for sending status , headers , body as a response
        return new ResponseEntity<String>(msg,headers, HttpStatus.OK);
    }

    @GetMapping("/requests")
    //@RolesAllowed("manager")
    ResponseEntity<List<Request>> getAllRequests(){
        List<Request>requests = iRequestService.getAll();
        return  ResponseEntity.ok().body(requests);


    }

    @PostMapping("/requests")
    ResponseEntity<Void> addRequest(@RequestBody Request request){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Request Added");
        int id = request.getAuditor().getAuditorId();
        Auditor auditor = auditorRepository.findById(id).get();
        List<Actor> actor = request.getActors();

        request.setAuditor(auditor);
        request.setStatus("TODO");
        request.setCreatedBy("vijay");
        request.setCreatedAt(LocalDateTime.now());
        iRequestService.addRequest(request);

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();// Build Methods helps to build the ResponseEntity with No Body

    }

    @PutMapping("/requests")
    ResponseEntity<Void> updateRequest(@RequestBody Request request){
        iRequestService.updateRequest(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Request Added");

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();// Build Methods helps to build the ResponseEntity with No Body

    }

    @GetMapping("/auditors")
        //@RolesAllowed("manager")
    ResponseEntity<List<Auditor>> getAllAuditors(){
        List<Auditor>auditors = iAuditorService.getAllAuditors();
        return  ResponseEntity.ok().body(auditors);


    }
    @GetMapping("/request/auditor/{name}")
    List<Request> getAllRequestsByAuditorId(@PathVariable("name") String auditorName){
    return iRequestService.getAllRequestsByAuditorId(auditorName);
    }


    @GetMapping("/request/manager/{manager}")
    List<Request> getAllRequestsForManager(@PathVariable("manager") String manager){
    return iRequestService.getAllRequestsForManager(manager);
    }



    @GetMapping("/actors")
    List<Actor> getAllActors(){
    return iActorService.getAllActors();
    }




}
