package template;

/**
 * 差分数组模板
 */
public class Difference {

    /**
     * 差分数组
     */
    private int[] diff;

    public Difference(int[] nums){
        assert nums.length > 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间[i,j]增加value(可以是负数)
     * @param i
     * @param j
     * @param value
     */
    public void increment(int i, int j, int value){
        diff[i] += value;
        if(j + 1 < diff.length){
            diff[j + 1] -= value;
        }
    }

    /**
     * 返回结果数组
     * @return
     */
    public int[] result(){
        int[] res = new int[diff.length];
        //根据差分数组反推结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
