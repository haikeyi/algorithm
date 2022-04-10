package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口题目
 */
public class Solution4 {

    /**
     * 76 最小覆盖字串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            need.put(key,need.getOrDefault(key,0) + 1);
        }

        int right = 0,left = 0;
        int valid = 0;
        //记录最小覆盖字串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            //即将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否需要收缩
            while (valid == need.size()){
                // 在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                // d 是即将移出窗口的字符
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        //返回最小覆盖字串
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    /**
     * 567 字符串的排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        return false;
    }
}
