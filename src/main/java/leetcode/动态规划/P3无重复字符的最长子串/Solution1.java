package leetcode.动态规划.P3无重复字符的最长子串;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5503 👎 0

import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    // 4:51 下午	info
    //				解答成功:
    //				执行耗时:2 ms,击败了100.00% 的Java用户
    //				内存消耗:38.1 MB,击败了97.48% 的Java用户

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int ans = 1;
        int[] map = new int[256];
        int preLength = 1;
        map[s.charAt(0)] = 0;
        for (int index = 1; index < s.length(); index++) {
            char curChar = s.charAt(index);
            preLength = Math.min(preLength + 1, index - map[curChar]);
            ans = Math.max(ans, preLength);
            // 更新当前字符最后出现的位置
            map[curChar] = index;
        }
        return ans;
    }

    public static class TestClass {
        @Test
        public void test() {
            // 示例 1:
            //
            //
            //输入: s = "abcabcbb"
            //输出: 3
            //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
            String s = "abcabcbb";
            Solution1 solution = new Solution1();
            int ans = solution.lengthOfLongestSubstring(s);
            System.out.println(ans);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
