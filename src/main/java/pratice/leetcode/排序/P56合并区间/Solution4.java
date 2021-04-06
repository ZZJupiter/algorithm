package pratice.leetcode.排序.P56合并区间;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组
// 👍 882 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {

    /*
    4:48 下午	info
				解答成功:
				执行耗时:9 ms,击败了34.27% 的Java用户
				内存消耗:41.5 MB,击败了5.11% 的Java用户
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[] {L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static class Test1 {
        //{1, 3}, {4, 6}, {3, 6}, {5, 6}, {15, 18}, {6, 11}
        // 1,11  15,18
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 3}, {4, 6}, {3, 6}, {5, 6}, {15, 18}, {6, 11}};
            Solution4 solution = new Solution4();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test2 {
        // {1, 4}, {2, 3}
        // 1,4
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 4}, {2, 3}};
            Solution4 solution = new Solution4();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test3 {
        //{1, 4}, {0, 5}
        //0,5
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 4}, {0, 5}};
            Solution4 solution = new Solution4();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test4 {
        //测试用例:[[2,3],[4,5],[6,7],[8,9],[1,10]]
        //期望结果:[[1,10]]
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
            Solution4 solution = new Solution4();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test5 {
        //测试用例:[[1,3],[0,2],[2,3],[4,6],[4,5],[5,5],[0,2],[3,3]]
        //期望结果:[[0,3],[4,6]]
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
            Solution4 solution = new Solution4();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

