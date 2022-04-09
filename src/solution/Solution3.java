package solution;



/**
 * 差分数组题目
 */
public class Solution3 {

    /**
     * 370 区间加法
     *
     * @param length
     * @param updates
     * @return
     */
    static int[] getModifiedArray(int length, int[][] updates) {

        //构造差分数组(由于原数组全为0，所以差分数组也全为0，此处无需构造)
        int[] diff = new int[length];

        for (int[] update : updates) {
            //差分数组区间加法
            increment(diff, update[0], update[1], update[2]);
        }
        int[] result = new int[diff.length];
        result[0] = diff[0];
        //根据差分数组反推原数组
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

    /**
     * 差分数组区间加法
     *
     * @param diff
     * @param i
     * @param j
     * @param value
     */
    static void increment(int[] diff, int i, int j, int value) {
        diff[i] += value;
        if (j + 1 < diff.length) {
            diff[j + 1] -= value;
        }
    }


    /**
     * 1109 航班预订统计
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //差分数组（原数组为0，此处差分数组也都为0）
        int[] diff = new int[n];
        if(bookings.length == 0){
            return diff;
        }
        for(int[] booking : bookings){
            //差分数组实现区间加法
            increment(diff,booking[0] - 1,booking[1] - 1,booking[2]);
        }
        //差分数组反推为原数组
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

    /**
     * 1094 拼车
     * @param trips
     * @param capacity
     * @return
     */
    public static boolean carPooling(int[][] trips, int capacity) {
        //差分数组 表示每一公里的载客量
        int[] diff = new int[1001];
        //区间加法 每个区间加上接到的乘客数量
        for(int[] trip : trips){
            passengerIncrement(diff,trip[1],trip[2],trip[0]);
        }
        //反推原数组
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        //遍历结果数组，看是否超过容量
        for(int i : result){
            if(i > capacity){
                return false;
            }
        }
        return true;
    }

    static void passengerIncrement(int[] diff, int i, int j, int value){
        diff[i] += value;
        diff[j] -= value;
    }

    public static void main(String[] args) {
//        int[][] updates = new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
//        int length = 5;
//        System.out.println(Arrays.toString(getModifiedArray(length, updates)));
        int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        System.out.println(carPooling(trips,capacity));

    }
}
