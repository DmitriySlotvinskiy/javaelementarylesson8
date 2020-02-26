package com.slotvinskiy;


//       Tree1              Tree2                 result Tree

//         1                  2                      3
//       /   \              /   \                  /   \
//      3     2            1     3                4     5
//     /                    \     \              / \     \
//    5                      4     7            5   4     7

public class SumTrees {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        TreeNode t3 = mergeTrees(t1, t2);
        printNode(t3);
    }

    public static void printNode(TreeNode root) {
        if (root.left != null) {
            printNode(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            printNode(root.right);
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode resultTree = mergeNodes(t1, t2);
        if (hasLeftAtLeastOneOf(t1, t2)) {
            if (t1.left != null && t2.left != null) {
                resultTree.left = mergeTrees(t1.left, t2.left);
            } else if (t1.left == null && t2.left != null) {
                resultTree.left = mergeTrees(new TreeNode(0), t2.left);
            } else if (t1.left != null && t2.left == null) {
                resultTree.left = mergeTrees(t1.left, new TreeNode(0));
            }
        }
        if (hasRightAtLeastOneOf(t1, t2)) {
            if (t1.right != null && t2.right != null) {
                resultTree.right = mergeTrees(t1.right, t2.right);
            } else if (t1.right == null && t2.right != null) {
                resultTree.right = mergeTrees(new TreeNode(0), t2.right);
            } else if (t1.right != null && t2.right == null) {
                resultTree.right = mergeTrees(t1.right, new TreeNode(0));
            }
        }
        return resultTree;
    }

    private static TreeNode mergeNodes(TreeNode t1, TreeNode t2) {
        return new TreeNode(t1.val + t2.val);
    }

    private static boolean hasLeftAtLeastOneOf(TreeNode t1, TreeNode t2) {
        if (t1.left != null && t2.left != null) {
            return true;
        } else if (t1.left == null && t2.left != null) {
            return true;
        } else if (t2.left == null && t1.left != null) {
            return true;
        }
        return false;
    }

    private static boolean hasRightAtLeastOneOf(TreeNode t1, TreeNode t2) {
        if (t1.right != null && t2.right != null) {
            return true;
        } else if (t1.right == null && t2.right != null) {
            return true;
        } else if (t2.right == null && t1.right != null) {
            return true;
        }
        return false;
    }
}
