package com.jeesite.modules.txey.web;

import com.jeesite.modules.data.MultipleDataSourceSetup;
import com.jeesite.modules.txey.entity.Bcjl;
import com.jeesite.modules.txey.service.BcjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "${adminPath}/txey/stats")
public class BcjlController {
    @Autowired
    private BcjlService bcjlService;
    @Autowired
    private MultipleDataSourceSetup multipleDataSourceSetup;

    @RequestMapping(value = "bcjl")
    private String bcjl(@RequestParam Map<String, Object> paramMap, Model model){

        multipleDataSourceSetup.setEmrDataSource();
        List<Bcjl> list = bcjlService.getBcjl(paramMap);
        for (Bcjl bcjl : list) {
           System.out.println(bcjl);
       }
        model.addAttribute("list", list);
        model.addAttribute("paramMap", paramMap);
        multipleDataSourceSetup.setDataSource();
        return "modules/txey/bcjlList";
    }
}
