package solution;

/**
 * 字串 前缀题目
 */
public class Solution2 {
    /**
     * 14 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String firstStr = strs[0];
        for (int j = 0; j < firstStr.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                //第i个字符的j位
                if(j > strs[i].length() && strs[i].charAt(j) != firstStr.charAt(j)){
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(strs[0].charAt(j));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abc","abcdd"};
        System.out.println(longestCommonPrefix(strs));
    }
}
