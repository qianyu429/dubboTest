package utils;


import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/4/12.
 */
public class FindFunction {

    public int findByHalf(int[] array , int tag){

        int low = 0;
        int high=array.length;
        int mid =(low + high) / 2 ;
        for (int i=low;i<=high;i++){
            if (array[mid]<tag) {
                low = mid+1;
            }
            if (array[mid]==tag) {
                return mid;
            }
            else high =mid-1;
        }
        return -1;
    }

    @Test
    public void findTest(){
        int [] ab ={2,11,21,24,31,9,45,18};
        int cc =findByHalf(ab,21);
        System.out.println("查询到的数据为:"+ cc);

    }
}
