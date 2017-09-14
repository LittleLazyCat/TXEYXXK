package com.jeesite.modules.txey.service;

import com.jeesite.modules.txey.dao.PatientDao;
import com.jeesite.modules.txey.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;

    public List<Patient> getPatient(){
        return patientDao.getPatient();
    }
}
