package com.CollectionFrameWorks.Trees.DFS;
import java.util.*;
import java.util.Arrays;
import java.util.Stack;

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
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dia = leftHeight + rightHeight+1;
        diameter = Math.max(dia,diameter);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
//        TreeNode left=invertTree(root.left);
//        TreeNode right=invertTree(root.right);
//        root.left=right;
//        root.right=left;
        TreeNode left=invertTree(root.left);
        root.left= invertTree(root.right);
        root.right=left;
        return root;
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode current=root;
        while (current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while (temp != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right=current.left;
                current.left = null;
            }
            current = current.right;
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
        if (root==null){
            return null;
        }
        if (root == p|| root==q ){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null){
            return root;
        }
        return left==null ? right:left;

    }
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).val;

    }
    private TreeNode helper(TreeNode node,int k){
        if (node==null){
            return null;
        }
        TreeNode left=helper(node.left,k);
        if (left!=null){
            return left;
        }
        count++;
        if (count==k){
            return node;
        }
        return helper(node.right,k);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int root =preorder[0];
        int index = 0;
        while (inorder[index] != root) index++;
        TreeNode node =new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
    private static int preIndex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length==0){
            return  null;
        }
        preIndex=0;
        return helpp(preorder,postorder,0,postorder.length-1);
    }

    private TreeNode helpp(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if(preIndex>=preorder.length || postStart>postEnd ) return null;
        TreeNode root = new TreeNode(preorder[postStart++]);
        if(postStart==postEnd || preIndex>=preorder.length){
            return root;
        }
        int leftSubTreeRootIndex=findindex(postorder,postStart,postEnd,preorder[preIndex]);
        root.left= helpp(preorder,postorder,postStart,leftSubTreeRootIndex);
        root.right= helpp(preorder,postorder,leftSubTreeRootIndex+1,postEnd-1);
        return root;
    }

    private int findindex(int[] postOrder, int start, int end, int value) {
        for(int i=start;i<=end;i++){
            if(postOrder[i]==value){
                return i;
            }
        }
        return -1;
    }
    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//    public String serialize(TreeNode root) {
//
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null|| root.val==val){
            return root;
        }
        if (val>root.val){
            return searchBST(root.right,val);
        }
        return searchBST(root.left,val) ;

    }
    //https://leetcode.com/problems/path-sum/

    public int sumNumbers(TreeNode root) {
       return help(root,0);

    }
    private int help(TreeNode node,int sum){
        if(node == null) return 0;
        sum += sum*10+node.val;
        if(node.left == null && node.right == null) return sum;
        return help(node.left,sum)+help(node.right,sum);
    }
    void DFSUsingStack(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode removed=stack.pop();
            System.out.println(removed.val+" ");
            if (removed.right != null){
                stack.push(removed.right);
            }else if (removed.left != null){
                stack.push(removed.left);
            }
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if ((p!=null||q==null) &&(p==null||q!=null)){
            return false;
        }
        if (p.val==q.val){
            return true;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    int answer =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        help(root);
        return answer;
    }
    private int help(TreeNode node){
        if(node == null){
            return 0;
        }
        int left= help(node.left);
        int right= help(node.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int pathSum=left + right+node.val;
        answer =Math.max(pathSum, answer);
        return Math.max(left,right)+node.val;

    }
    public boolean findPath(TreeNode node,int[] arr){
        if(node==null) return arr.length==0;
        return helperFun(node,arr,0);
    }
    private boolean helperFun(TreeNode node, int[] arr, int index) {
        if (node==null) return false;
        if (index>=arr.length||node.val!=arr[index]) return false;
        if (node.left==null && node.right==null && index==arr.length-1) return true;
        return helperFun(node.left,arr,index++) || helperFun(node.right,arr,index++);
    }
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack=new Stack<>();
        int i = 0;
        while (i<traversal.length()){
            int level=0;
            while (i<traversal.length() && traversal.charAt(i)=='-'){
                level++;
                i++;
            }
            int val=0;
            while (i<traversal.length() && Character.isDigit(traversal.charAt(i))){
                val=val*10+(traversal.charAt(i)-'0');
                i++;
            }
            TreeNode node=new TreeNode(val);
            while (stack.size()>level){
                stack.pop();
            }
            if (!stack.isEmpty()){
                TreeNode parent=stack.peek();
                if(parent.left==null){
                    parent.left=node;
                }
                else {
                    parent.right=node;
                }
            }
            stack.push(node);
        }
        return stack.get(0);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        findPaths(root,targetSum,result,currentPath);
        return result;
    }

    private void findPaths(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {
        if(root==null) return;
        currentPath.add(root.val);
        if (root.val==targetSum&& root.left==null&& root.right==null){
            result.add(new ArrayList<>(currentPath));
        }
        else {
            findPaths(root.left,targetSum-root.val,result,currentPath);
            findPaths(root.right,targetSum-root.val,result,currentPath);
        }
        currentPath.remove(currentPath.size()-1);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.val == targetSum && root.left==null && root.right==null){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left==null){
            return 1+minDepth(root.right);
        }
        if(root.right==null){
            return 1+minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        deleteNode(root.left,key);
        deleteNode(root.right,key);
        if(root.val==key){
            root=root.right;
        }
        return root;
    }
//    public String serialize(TreeNode root) {
//        List<String> list =new ArrayList<>();
//        helpSerialize(root,list);
//        String str = list.toString();
//    }
//
//    private void helpSerialize(TreeNode root, List<String> list) {
//        if(root == null) {
//            list.add(null);
//            return;
//        }
//        list.add(String.valueOf(root.val));
//        helpSerialize(root.left,list);
//        helpSerialize(root.right,list);
//
//    }

//    public TreeNode deserialize(String data) {
//
//    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            constructPaths(root, "", paths);
        }
        return paths;
    }

    private void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += node.val;
            if (node.left == null && node.right == null) { // It's a leaf node
                paths.add(path);
            } else {
                path += "->";
                constructPaths(node.left, path, paths);
                constructPaths(node.right, path, paths);
            }
        }
    }
}
