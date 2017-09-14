package com.thinkgem.jeesite.test;


import com.thinkgem.jeesite.test.entity.TestArea;
import com.thinkgem.jeesite.test.service.TestAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-context.xml" })
public class AreaServiceTest{



	@Autowired
	TestAreaService testAreaService;

	@Test
	public void getTestArea() {

		List<TestArea> testList =testAreaService.getArea();
		for (TestArea tl : testList) {
			System.out.println(tl);
		}

	}
}
