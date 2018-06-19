package rpc.cif;

import com.shhxzq.fin.cif.service.AuthService;
import com.shhxzq.fin.cif.service.LoginService;
import com.shhxzq.fin.cif.vo.LoginArg;
import com.shhxzq.fin.cif.vo.LoginRet;
import dataprovider.DataForTest;
import lombok.extern.log4j.Log4j2;
import org.assertj.db.type.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RpcTestBase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.api.Assertions.assertThat;


/**
 * Created by duanzonghai on 2018/3/22.
 */
@Log4j2
public class LoginTest extends RpcTestBase {

    @Autowired
    private LoginService loginService;

    @Autowired
    private  AuthService authService;

    @BeforeMethod
    public void dataReady(){
        System.out.println("数据准备ok");
    }

    @Test(dataProvider="dataFo",dataProviderClass = DataForTest.class)
    public void testLogin(String userName,String password,boolean captchaCorrect){
        LoginArg loginArg = new LoginArg();
        loginArg.setCaptchaCorrect(captchaCorrect);
        loginArg.setLoginName(userName);
        loginArg.setPasswd(password);

        LoginRet loginRet = loginService.login(loginArg);

        String custNo=loginRet.getCustNo();
        String token=loginRet.getToken();
        String errNo=loginRet.getErrNo();
        String errMsg=loginRet.getErrMsg();

        Request custBaseRequest =new Request(cifJdbcTemplate.getDataSource(),"Select * from cif_cust_base where cust_no="+custNo);

        System.out.println("测试结果:");
        log.info("看看是否通过");
        assertThat(custBaseRequest).column("cust_no").value().isEqualTo(custNo);

    }

}

