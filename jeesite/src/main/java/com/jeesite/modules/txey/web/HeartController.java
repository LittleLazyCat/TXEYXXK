package com.jeesite.modules.txey.web;

import com.jeesite.modules.data.MultipleDataSourceSetup;
import com.jeesite.modules.txey.entity.Heart;
import com.jeesite.modules.txey.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "${adminPath}/txey/stats")
public class HeartController {
    @Autowired
    private HeartService heartService;
    @Autowired
    private MultipleDataSourceSetup multipleDataSourceSetup;

    @RequestMapping(value = "heart")
    public String heart(@RequestParam Map<String, Object> paramMap, Model model) {

        multipleDataSourceSetup.setHisDataSource();
        List<Heart> list = heartService.heartStats(paramMap);
        model.addAttribute("list", list);
        model.addAttribute("paramMap", paramMap);
        multipleDataSourceSetup.setDataSource();
        return "modules/txey/statsHeart";
    }
}
