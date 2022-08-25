package com.acheron.offlinecommunication.service;

import com.acheron.offlinecommunication.model.Auditor;
import com.acheron.offlinecommunication.repository.AuditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditorServiceImpl implements IAuditorService{

    private AuditorRepository auditorRepository;

    @Autowired
    public void setAuditorRepository(AuditorRepository auditorRepository) {
        this.auditorRepository = auditorRepository;
    }

    @Override
    public List<Auditor> getAllAuditors() {
        return auditorRepository.findAll();
    }
}
