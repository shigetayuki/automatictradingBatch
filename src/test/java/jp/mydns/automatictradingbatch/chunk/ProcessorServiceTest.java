package jp.mydns.automatictradingbatch.chunk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.mydns.automatictradingbatch.service.ProcessorService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessorServiceTest {
    @Value("${authentication.user}")
    private String user;

    @Value("${authentication.password}")
    private String password;

    @Value("${server.url}")
    private String url;

    @Autowired
    private ProcessorService processorService;
    
    @Test
    public void authenticationTest()throws Exception{
        String token = processorService.authentication(user,password,url);
        System.out.println(token);
    }

}
