package com.jeesite.modules.txey.web;


import com.jeesite.modules.data.MultipleDataSourceSetup;
import com.jeesite.modules.txey.entity.Patient;
import com.jeesite.modules.txey.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "${adminPath}/txey/stats")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MultipleDataSourceSetup multipleDataSourceSetup;

    @RequestMapping(value = "patient")
    public String patientInfo(Model model){
        multipleDataSourceSetup.setHisDataSource();
        List<Patient> patientList = patientService.getPatient();
        multipleDataSourceSetup.setDataSource();
        model.addAttribute("list",patientList);
        return "modules/txey/statsPatient";
    }
}
