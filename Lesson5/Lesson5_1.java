/*
* 舍罕王和他的宰相西萨·班·达依尔现在来到了当代。这次国王学乖了，
* 他对宰相说：“这次我不用麦子奖赏你了，我直接给你货币。另外，我也不用棋盘了，
* 我直接给你一个固定数额的奖赏。”
* 宰相思考了一下，回答道：“没问题，陛下，就按照您的意愿。
* 不过，我有个小小的要求。那就是您能否列出所有可能的奖赏方式，
* 让我自己来选呢？假设有四种面额的钱币，1 元、2 元、5 元和 10 元，而您一共给我 10 元，
* 那您可以奖赏我 1 张 10 元，或者 10 张 1 元，或者 5 张 1 元外加 1 张 5 元等等。
* 如果考虑每次奖赏的金额和先后顺序，那么最终一共有多少种不同的奖赏方式呢？”
*/
import java.util.ArrayList;
public class Lesson5_1 {
    public static long[] rewards={1,2,5,10};  //四种面额的纸币
    /*
    * @Description 使用递归
    * @param totalReward- 奖赏总金额，result-保存当前解
    * @return void
    */
    public static void get(long totalReward, ArrayList<Long> result){
        //当 totalReward = 0 时，证明这是满足条件的解，输出解
        if(totalReward==0){
            System.out.println(result);
            return;
        }
        //当 totalReward < 0 时，证明当前解不满足条件，不输出
        else if(totalReward<0){
            return;
        }
        else{
            for(int i=0; i<rewards.length;++i){
                ArrayList<Long> newResult=(ArrayList<Long>)(result.clone());
                newResult.add(rewards[i]);
                get(totalReward-rewards[i],newResult);
            }
        }
    }
    public static void main(String[] args){
        int totalReward=10;
        Lesson5_1.get(totalReward,new ArrayList<Long>());
    }
}

