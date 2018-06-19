package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by duanzonghai on 2018/3/21.
 */
@ContextConfiguration(locations ={"/spring-dubbo.xml","/spring-dubbo-customer.xml","/datasource.xml"} )
public class RpcTestBase extends AbstractTestNGSpringContextTests {
        @Autowired
        protected JdbcTemplate cifJdbcTemplate;

}
