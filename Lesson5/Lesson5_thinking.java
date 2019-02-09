/*
*一个整数可以被分解为多个整数的乘积，例如，6 可以分解为 2x3。
* 请使用递归编程的方法，为给定的整数 n，找到所有可能的分解（1 在解中最多只能出现 1 次）。
* 例如，输入 8，输出是可以是 1x8, 8x1, 2x4, 4x2, 1x2x2x2, 1x2x4, ……
* */
import java.util.ArrayList;
public class Lesson5_thinking {
    /*
    * @Description
    * @param totalNum-需要因式分解的数字 result-保存当前解
    * */
    public static void get(long totalNum, ArrayList<Long> result){
        // 如果 totalNum =1 ，则当前解符合条件
        if(totalNum==1){
            if(!result.contains(1L))  //判断当前解是否包含 1
                result.add(1L);
            System.out.println(result);
            return;
        }
        else{
            for(long i=1;i<=totalNum;++i){
                if((i==1)&&(result.contains(1L)))
                    continue;
                ArrayList<Long> newResult=(ArrayList<Long>)(result.clone());
                newResult.add(Long.valueOf(i));
                if(totalNum%i!=0)  //如果当前值不能被整除，就会通过创建新的 newResult 对象舍去当前值
                    continue;
                get(totalNum/i,newResult);
            }
        }
    }
    public static void main(String[] args){
        int totalNum=8;
        Lesson5_thinking.get(totalNum,new ArrayList<Long>());
    }
}
