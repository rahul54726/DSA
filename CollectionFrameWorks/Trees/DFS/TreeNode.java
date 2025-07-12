package com.CollectionFrameWorks.Trees.DFS;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int dia=leftHeight + rightHeight  + 1;
        diameter=Math.max(diameter , dia );
        return Math.max(leftHeight , rightHeight ) + 1;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);
        root.left= invertTree(root.right);
        root.right=left;
        return root;
    }
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode current =root;
        while (current != null){
            if (current.left != null){
                 TreeNode temp = current.left;
                 while (temp.right != null){
                     temp=temp.right;
                 }
                 temp.right=current.right;
                 current.right=current.left;
                 current.left=null;
            }
            current=current.right;
        }

    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    private boolean helper(TreeNode node, Integer low , Integer high) {
        if (node == null){
            return true;
        }
        if ( low!= null && node.val <= low){
            return false;
        }
        if (high != null && node.val>=high){
            return false;
        }
        boolean leftTree = helper(node.left,low,node.val);
        boolean rightTree = helper(node.right,node.val,high);
        return leftTree && rightTree;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }

}
