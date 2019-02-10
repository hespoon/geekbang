/*归并排序 从小到大*/
import java.util.Arrays;
public class merge_sort {

   /*
   @Description 利用递归调用，实现归并排序
   @param to_sort 待排序的数组
   @return int[] 排序后的数组
    */
    public static int[] mergeSort(int[] to_sort){
        if(to_sort==null)  //如果收到的数组是空数组
            return new int[0];  //返回一个长度为 0 的数组
        if(to_sort.length==1)  //如果数组的长度为 1
            return to_sort;  //返回当前数组
        //将数组分为两半
        int mid=to_sort.length/2;
        int[] left=Arrays.copyOfRange(to_sort,0,mid);
        int[] right=Arrays.copyOfRange(to_sort,mid,to_sort.length);

        //嵌套调用
        left=mergeSort(left);
        right=mergeSort(right);

        //合并分开后的数组
        int[] merges=merge(left,right);
        return merges;
    }

    /*
    @Description 归并函数
    @param int[] left 已经有序的数组 （从小到大）
    @param int[] right 已经有序的数组 （从小到大）
    @return int[] 归并以后的有序数组
     */
    public static int[] merge(int[] left,int[] right){
        if(left==null) left=new int[0];
        if(right==null) right=new int[0];

        int[] sorted=new int[left.length+right.length];
        int leftIndex=0;
        int rightIndex=0;
        int sortedIndex=0;

        // 从小到大合并两个数组
        while(leftIndex<left.length && rightIndex<right.length){
            if(left[leftIndex]<=right[rightIndex]){
                sorted[sortedIndex]=left[leftIndex];
                sortedIndex++;
                leftIndex++;
            }
            else{
                sorted[sortedIndex]=right[rightIndex];
                sortedIndex++;
                rightIndex++;
            }
        }

        //将剩下的数组加在有序数组后面
        if(leftIndex==left.length && rightIndex<right.length){
            do{
                sorted[sortedIndex]=right[rightIndex];
                sortedIndex++;
                rightIndex++;
            }while(rightIndex<right.length);
        }
        else if(leftIndex<left.length && rightIndex==right.length){
            do{
                sorted[sortedIndex]=left[leftIndex];
                sortedIndex++;
                leftIndex++;
            }while(leftIndex<left.length);
        }

//        for(int i=0;i<sorted.length;){
//            if(left[leftIndex]<=right[rightIndex]){
//                sorted[i]=left[leftIndex];
//                leftIndex++;
//                i++;
//                if(leftIndex==left.length && rightIndex<right.length){
//                    do{
//                        sorted[i]=right[rightIndex];
//                        rightIndex++;
//                        i++;
//                    }while(i<sorted.length);
//                    break;
//                }
//            }
//            else{
//                sorted[i]=right[rightIndex];
//                rightIndex++;
//                i++;
//                if(rightIndex==right.length && rightIndex==right.length){
//                    do{
//                        sorted[i]=left[leftIndex];
//                        leftIndex++;
//                        i++;
//                    }while(i<sorted.length);
//                    break;
//                }
//            }
//        }
        return sorted;
    }
    public static void main(String[] ages){
        int[] sortArray={2,5,3,6,4,1,45,66,5};
        for(int element:mergeSort(sortArray)){
            System.out.println(element);
        }
    }
}
