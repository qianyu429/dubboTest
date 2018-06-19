package utils;

import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/13.
 */
public class NumberChangeChiness {
    private static String[] num={"零","一","二","三","四","五","六","七","八","九"};
    private static String[] unit ={"","十","百","千","万","十","百","千","亿"};

    public static String numberChangeChiness(Integer number){
//        转换成字符串类型
        String str = String.valueOf(number);
        String out ="";
        //定义数组的长度
        String[] result = new String[str.length()];

        for (int i=0;i<result.length;i++){
            result[i]= String.valueOf(str.charAt(i));
        }
        for (int i=0;i<result.length;i++){
            int back;
            if (!result[i].equals("0")){
                back =result.length -i -1 ;
                out = out + num[Integer.parseInt(result[i])];
                out = out + unit[back];
            }else {
                if (i == result.length-5) {
                    out = out + unit[4];
                }
                if (i==result.length -1){

                }else {
                    if (result[i + 1].equals("0")) {

                    }
                    if (!result[i + 1].equals("0") && i!= result.length-5 ) {
                        out = out + num[0];
                    }
                }
            }
        }
        return out;
    }

    @Test
    public void testNumberChangeChiness(){
        Integer number =203530;
        String str = NumberChangeChiness.numberChangeChiness(number);
        System.out.println("转换后的结果为:" + str);
    }
}
