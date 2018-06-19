package utils;

import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/2.
 */
public class CompareTools {

    /**
     *通过reverse方法生成逆向字符串然后和之前的对比进行判断是否为对称型字符
     * @param str
     * @return
     */
    public boolean isSymmetry(String str){
//        转换成StringBuffer
        StringBuffer sb = new StringBuffer(str);
//        reverse()取返方法逆向取值
        String newString = sb.reverse().toString();
        return str.equals(newString);
    }

    /**
     *
     * @param str
     * @return
     */
    public boolean isSymmetryMethodTwo(String str){
        if (str == null)
            return false;
        if (str.equals("") || str.length()==1)
            return true;
        for (int i=0;i<str.length() / 2;i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }

    @Test
    public void testTools(){
        String str = "1221";
        boolean me =isSymmetryMethodTwo(str);
        System.out.println("字符串为对称性字符吗?" + me);
    }
}
