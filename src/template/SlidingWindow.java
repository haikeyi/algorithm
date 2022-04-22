package template;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口框架
 */
public class SlidingWindow {

    /**
     * 套模板，思考四个问题：
     * 1、当移动 right 扩大窗口，即加入字符时，应该更新哪些数据？
     * 2、什么条件下，窗口应该暂停扩大，开始移动 left 缩小窗口？
     * 3、当移动 left 缩小窗口，即移出字符时，应该更新哪些数据？
     * 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
     */

    /* 滑动窗口算法框架 */
    void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            need.put(key,need.getOrDefault(key,0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
        // c 是将移入窗口的字符
            char c = s.charAt(right);
        // 右移窗口
            right++;
        // 进行窗口内数据的一系列更新
            // ...

        /*** debug 输出的位置 ***/
            System.out.println("window:[" + left + "," + right + "]");
        /********************/
        // 判断左侧窗口是否要收缩
            //while (window needs shrink) {
        // d 是将移出窗口的字符
                char d = s.charAt(left);
            // 左移窗口
                left++;
            // 进行窗口内数据的一系列更新
            //...
            //}
        }
    }
}
