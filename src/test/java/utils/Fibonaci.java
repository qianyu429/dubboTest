package utils;

import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/27.
 */
public class Fibonaci {

    /**
     * 使用递归方法计算斐波那契数列
     * @param n
     * @return
     */
    private static int fibonacci(int n){
        int fn = 0;

        if (n<=0){
            System.out.println("n必须大于0");
            return -1;
        }else {
            if (n<=2){
                return fn = 1;
            }else {
               return fn = fibonacci(n-1) + fibonacci(n-2);
            }
        }
    }

    /**
     * 使用非递归方法利用数组计算斐波那契数列
     * @param n
     * @return
     */
    private static int fibonacciByArray(int n){
        int[] array = new int[n+1];
        array[0] =0;
        array[1] =1;

        for (int i=2;i<array.length;i++){
           array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }

    /**
     * 使用非递归的方法计算斐波那契数列
     * @param n
     * @return
     */

    private static int fibonacciByInt(int n){
        int first = 0;
        int second = 1;
        int fn = 0;
        if (n ==0) {
            return  fn =0;
        }

        if (n<=2 && n >0){
            return fn =1;
        }

        for (int i =2; i<n+1;i++){
            fn = first + second;
            first = second;
            second = fn ;
        }
        return fn;
    }

    @Test
    public void fibonacciTest(){
       System.out.println(fibonacci(4));
       System.out.println(fibonacciByArray(3));
       System.out.println(fibonacciByInt(5));
    }
}
