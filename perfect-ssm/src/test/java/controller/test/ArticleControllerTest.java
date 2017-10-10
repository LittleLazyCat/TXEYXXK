package controller.test;

import com.alibaba.fastjson.JSONObject;
import com.ssm.promotion.core.entity.Article;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.txey.wxgzh.zyqd.dao.ExpenseDao;
import com.txey.wxgzh.zyqd.entity.Expense;
import com.txey.wxgzh.zyqd.entity.Inpatient;
import com.txey.wxgzh.zyqd.entity.Payment;
import com.txey.wxgzh.zyqd.service.ExpenseService;
import com.txey.wxgzh.zyqd.service.impl.ExpenseServiceImpl;
import com.txey.wxgzh.zyqd.service.impl.InpatientServiceImpl;
import com.txey.wxgzh.zyqd.service.impl.PaymentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Springmvc 单元测试类
 *
 * @author 13 2016-07-06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/spring-context.xml", "classpath*:/spring-context-mvc.xml", "classpath*:/mybatis-config.xml"})
public class ArticleControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private InpatientServiceImpl inpatientService;

    @Autowired
    private PaymentServiceImpl paymentService;


    @Autowired
    private ExpenseServiceImpl expenseService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testArticleList() throws Exception {
        //创建文章列表的请求
        //请求方式为get
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.request(HttpMethod.GET, "/articles");
        //此请求并不需要添加请求参数
        mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void testArticleAdd() throws Exception {
        //创建文章对象
        Article article = new Article();
        article.setAddName("13");
        article.setArticleTitle("title");
        article.setArticleContent("content");
        String requestParam = JSONObject.toJSONString(article);
        //请求方式为post
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/articles");
        mockMvc.perform(mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON).content(requestParam)).andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getInpatientByZyhTest() {
        Inpatient inpatients = inpatientService.getInpatientByZyhm("00290001");

        System.out.println(inpatients);

    }


    @Test
    public void getPaymentByZyhTest(){
        List<Payment> payments = paymentService.getPaymentByZyh("00290001");
        for(Payment payment:payments)
        {
            System.out.println(payment);
        }
    }

    @Test
    public void getExpenseByZyhTest(){
        List<Expense> expenseList = expenseService.getExpenseByZyh("00290001");
        for(Expense expense:expenseList)
        {
            System.out.println(expense);
        }
        String str=null;

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        // String转Date
        str = "2017-10-06";
        try {
            date = format1.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        expenseList = expenseService.getExpenseDetailByzyh("00290001", str);

        for(Expense expense:expenseList)
        {
            System.out.print("查询：");
            System.out.println(expense);
        }
    }

}  