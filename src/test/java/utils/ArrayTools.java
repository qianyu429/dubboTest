package utils;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by duanzonghai on 2018/4/16.
 */
public class ArrayTools {

    /**
     * 获取2个数组的并集
     * 交集 retainAll()
     * 差集 removeAll()
     * @param str1
     * @param str2
     * @return
     */
    private static String[] unionOfTwoArray(String[] str1,String[] str2) {
        Set<String> set = new HashSet<String>();
        for(String str: str1){
            set.add(str);
        }
        for (String str: str2){
            set.add(str);
        }

        String[] result ={};
        return set.toArray(result);
    }



    /**
     *获取颜色List列表中的颜色种类(使用list中的元素做对比,这里要求list是有序排序的)
     * @param list
     * @return
     */
    private static int getColorSum(List<String> list){
        int sum = 1;
        System.out.println(list.get(0));
        for (int i=1;i<list.size();i++){
            if (!list.get(i).equals(list.get(i-1))){
                sum ++;
                System.out.println(list.get(i));
            }
        }
        System.out.println("颜色list的颜色种类有:" + sum);
        return sum;
    }

    /**
     * 利用set的元素不可重复特性,将list列表中的颜色遍历添加到set中去,然后求set的元素个数
     * @param list
     * @return
     */
    private static int getColorSumBySet(List<String> list){
        Set<String> set = new HashSet<String>();
        for (String color:list){
            set.add(color);
        }
        System.out.println("颜色list的颜色种类有:" + set.size());
        return set.size();
    }

    @Test
    public void testArray(){
//        String[] str1 ={"3","5","7","9"};
//        String[] str2 ={"3","4","5","6"};
//        String[] result=unionOfTwoArray(str1,str2);
//        System.out.println("数组的并集为:\n");
//        for (String st : result){
//            System.out.println(st);
//        }
//
//        Date date = new Date();
//        String str = "YYYY-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
//        System.out.println(simpleDateFormat.format(date));

        List<String> list = new ArrayList<String>(){
            {
                add("blue");
                add("blue");
                add("black");
                add("green");
                add("green");
                add("red");
                add("white");
                add("white");
                add("pink");
                add("pink");
            }
        };
//        getColorSum(list);
        getColorSumBySet(list);


    }
}
