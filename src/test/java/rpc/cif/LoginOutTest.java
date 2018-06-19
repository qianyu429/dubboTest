package rpc.cif;

import com.shhxzq.fin.cif.service.AuthService;
import com.shhxzq.fin.cif.service.LoginService;
import com.shhxzq.fin.cif.vo.LoginArg;
import com.shhxzq.fin.cif.vo.LoginRet;
import dataprovider.DataForTest;
import org.assertj.db.type.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import utils.RpcTestBase;
import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by duanzonghai on 2018/4/10.
 */
public class LoginOutTest extends RpcTestBase {
    @Autowired
    private AuthService authService;

    @Autowired
    private LoginService loginService;


    @Test(dataProvider = "dataFo",dataProviderClass = DataForTest.class)
    public void loginOutTest(String userName,String password,boolean captchaCorrect){

        LoginArg loginArg = new LoginArg();
        loginArg.setLoginName(userName);
        loginArg.setPasswd(password);
        loginArg.setCaptchaCorrect(captchaCorrect);

        LoginRet loginRet= loginService.login(loginArg);

        String custNo =loginRet.getCustNo();
        String token=loginRet.getToken();
        String errMsg=loginRet.getErrMsg();
        String errNo=loginRet.getErrNo();

        Request custBaseRequest = new Request(cifJdbcTemplate.getDataSource(),"select * from cif_cust_base where cust_no=" +custNo);

        assertThat(custBaseRequest).column("cust_no").value().isEqualTo(custNo);

        authService.logout(custNo,token);






    }
}
