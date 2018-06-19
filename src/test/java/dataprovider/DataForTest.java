package dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by duanzonghai on 2018/3/22.
 */
public class DataForTest {

    @DataProvider(name = "dataFo")
    public static Object [][] dataForTestLogin(){
        return new Object[][]{
                {"18019281731","qq789123",true},
                {"18019281731","qq789123",false}
        };
    }
}
