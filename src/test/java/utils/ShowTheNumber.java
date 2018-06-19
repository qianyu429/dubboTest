package utils;

import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/19.
 */
public class ShowTheNumber {

    private static void showTheEveryNumber(int number) {

        while ((number / 10) > 0) {
            System.out.println(number % 10);
            number = number / 10;
            if (number < 10) {
                System.out.println(number);
            }
        }
    }

    private static void showTheNumberByArray(int number){
        String str = String.valueOf(number);
        for (int i=0;i<str.length();i++){
            System.out.println(str.charAt(i));
        }
    }

    @Test
    public void testNumber() {
        int s = 83904;
//        showTheEveryNumber(s);
        showTheNumberByArray(s);

//        for (int counter=0;counter<10;counter++){
//            if (counter==4){
//                continue;
//            }
//            System.out.println(counter);
//        }
    }

}


