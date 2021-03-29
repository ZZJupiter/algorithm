package pratice.zuo.test.树.P222完全二叉树的节点个数;

/**
 * @author by catface
 * @date 2021/3/29 10:44 下午
 */
public class Solution2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);
        Solution2 solution2 = new Solution2();
        int count = solution2.countNodes(root);
        System.out.println(count);
    }

    public int countNodes(TreeNode root) {
        return getNum(root);
    }

    public int getH(TreeNode x) {
        if (x == null) {
            return 0;
        }
        return getH(x.left) + 1;
    }

    /**
     * 如果getNum的复杂度是x,则 x = logN + x/2
     * <p>
     * 因为子树的规模是父亲节点的一一半,所以复杂度是一半
     * <p>
     * x = 2logN ,顾略掉常数项 O(logN)
     *
     * @param x
     * @return
     */
    public int getNum(TreeNode x) {
        if (x == null) {
            return 0;
        }
        if (x.left == null && x.right == null) {
            return 1;
        }
        int h = getH(x);
        int rightSubH = getH(x.right);
        if (rightSubH + 1 == h) {
            int leftNum = (int)Math.pow(2, h - 1) - 1;
            int rightNum = getNum(x.right);
            return leftNum + 1 + rightNum;
        } else {
            int leftNum = getNum(x.left);
            int rightNum = (int)Math.pow(2, rightSubH) - 1;
            return leftNum + 1 + rightNum;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
