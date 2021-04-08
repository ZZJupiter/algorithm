package leetcode.排序.P56合并区间;

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
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2 {

    /*
        4:41 下午	info
				解答成功:
				执行耗时:324 ms,击败了5.30% 的Java用户
				内存消耗:41 MB,击败了78.14% 的Java用户
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return new int[0][2];
        }
        bubbleSort(intervals);
        List<int[]> merged = new ArrayList<>();
        int[] currentMerge = intervals[0];
        merged.add(currentMerge);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > currentMerge[1]) {
                currentMerge = intervals[i];
                merged.add(currentMerge);
            } else {
                currentMerge[1] = Math.max(currentMerge[1], intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public void bubbleSort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
    }

    public static class Test1 {
        //{1, 3}, {4, 6}, {3, 6}, {5, 6}, {15, 18}, {6, 11}
        // 1,11  15,18
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 3}, {4, 6}, {3, 6}, {5, 6}, {15, 18}, {6, 11}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test2 {
        // {1, 4}, {2, 3}
        // 1,4
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 4}, {2, 3}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test3 {
        //{1, 4}, {0, 5}
        //0,5
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 4}, {0, 5}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test4 {
        //测试用例:[[2,3],[4,5],[6,7],[8,9],[1,10]]
        //期望结果:[[1,10]]
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test5 {
        //测试用例:[[1,3],[0,2],[2,3],[4,6],[4,5],[5,5],[0,2],[3,3]]
        //期望结果:[[0,3],[4,6]]
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

    public static class Test6 {
        //测试用例:[[4,5],[1,4],[0,1]]
        //期望结果:[[0,5]]
        public static void main(String[] args) {
            int[][] intervals = new int[][] {{4, 5}, {1, 4}, {0, 1}};
            Solution2 solution = new Solution2();
            int[][] temp = solution.merge(intervals);
            System.out.println(temp);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

