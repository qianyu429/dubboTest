package utils;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/17.
 */
public class TowerOfHanoi {
    private static int m =0;

    public static void move(int disks,char N,char M){
        System.out.println("第"+ (++m) + "次移动:" + " 把" + disks + "号圆盘从" + N + "移动到" + M);

    }

    public static void  hanoi(int n,char A,char B,char C){
        if (n==1){
            TowerOfHanoi.move(1,A,C);
        }else{
            hanoi(n-1,A,C,B); //A移动到B,以C为辅助塔
            move(n,A,C);
            hanoi(n-1,B,A,C); //B移动到C上,以A为辅助塔
        }
    }

    @Test
    public void testForHanoi(){
        char A = 'A';
        char B = 'B';
        char C = 'C';
        hanoi(3,A,B,C);
    }
}
