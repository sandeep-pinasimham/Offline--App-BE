package com.acheron.offlinecommunication.service;

import com.acheron.offlinecommunication.model.Auditor;
import com.acheron.offlinecommunication.model.Request;

import java.util.List;

public interface IAuditorService {
    List<Auditor> getAllAuditors();
}
