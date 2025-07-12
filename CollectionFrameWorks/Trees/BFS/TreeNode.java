package com.CollectionFrameWorks.Trees.BFS;
import java.util.*;
public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode next;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;

      }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> que=new LinkedList<>();
            que.offer(root);
            while (!que.isEmpty()){
                int levelSize = que.size();
                List<Integer> currentLevelList=new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode=que.poll();
                    currentLevelList.add(currentNode.val);
                    if(currentNode.left!=null){
                        que.offer(currentNode.left);
                    }if(currentNode.right!=null){
                        que.offer(currentNode.right);
                    }
                }
                result.add(currentLevelList);

            }
            return result;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int levelSize = que.size();
            double avg=0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode=que.poll();
               avg += currentNode.val;

                if(currentNode.left!=null){
                    que.offer(currentNode.left);
                }if(currentNode.right!=null){
                    que.offer(currentNode.right);
                }
            }
            avg=avg/levelSize;
            result.add(avg);

        }
        return result;
    }
    public  TreeNode findSuccessor(TreeNode root, int key){
        if (root == null){
            return null;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int levelSize = que.size();
                TreeNode currentNode=que.poll();
                if(currentNode.left!=null){
                    que.offer(currentNode.left);
                }if(currentNode.right!=null){
                    que.offer(currentNode.right);
                }
                if (currentNode.val==key){
                    break;
                }


        }
        return que.peek();
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> que=new ArrayDeque<>();
        que.offer(root);
        boolean reverse=false;
        while (!que.isEmpty()){
            int levelSize = que.size();
            List<Integer> currentLevelList=new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if (!reverse){
                    TreeNode currentNode=que.pollFirst();
                    currentLevelList.add(currentNode.val);
                    if(currentNode.left!=null){
                        que.addLast(currentNode.left);
                    }if(currentNode.right!=null){
                        que.addLast(currentNode.right);
                    }
                }
                else {
                    TreeNode currentNode=que.pollLast();
                    currentLevelList.add(currentNode.val);
                    if(currentNode.right!=null){
                        que.addFirst(currentNode.right);
                    }if(currentNode.left!=null){
                        que.addFirst(currentNode.left);
                    }
                }
                reverse = !reverse;
            }
            result.add(currentLevelList);

        }
        return result;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> que=new ArrayDeque<>();
        que.offer(root);
        boolean reverse=false;
        while (!que.isEmpty()){
            int levelSize = que.size();
            List<Integer> currentLevelList=new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if (!reverse){
                    TreeNode currentNode=que.pollFirst();
                    currentLevelList.add(currentNode.val);
                    if(currentNode.left!=null){
                        que.addLast(currentNode.left);
                    }if(currentNode.right!=null){
                        que.addLast(currentNode.right);
                    }
                }
                else {
                    TreeNode currentNode=que.pollLast();
                    currentLevelList.add(currentNode.val);
                    if(currentNode.right!=null){
                        que.addFirst(currentNode.right);
                    }if(currentNode.left!=null){
                        que.addFirst(currentNode.left);
                    }
                }
                reverse = !reverse;
            }
            result.add(0,currentLevelList);

        }
        return result;
    }

    public TreeNode connect(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode leftMost=root;
        while (leftMost.left!=null){
            TreeNode current = leftMost;
            while (current!=null){
                current.left.next=current.right;
                if (current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            leftMost=leftMost.left;
        }
        return root;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode=que.poll();
                if (i==levelSize-1){
                    result.add(currentNode.val);
                }
                if(currentNode.left!=null){
                    que.offer(currentNode.left);
                }if(currentNode.right!=null){
                    que.offer(currentNode.right);
                }
            }


        }
        return result;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);


        return (
                (level(root,xx,0)==level(root,yy,0)) && !isSibling(root,xx,yy)
                );
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
          if (node==null){
              return false;
          }
          return (
                  (node.left==x && node.right==y) || (node.left==y && node.right==x)
                  || isSibling(node.left,x,y) || isSibling(node.right,x,y)
                  );
    }

    private int level(TreeNode node, TreeNode x, int lev) {
          if (node==null) {
              return 0;
          }
          if (node==x){
              return lev;
          }
          int l=level(node.left,x,lev+1);
          if (l!=0){
              return l;
          }
          return level(node.right,x,lev+1);
    }

    private TreeNode findNode(TreeNode node, int x) {
          if (node==null){
              return null;
          }
          if (node.val==x){
              return node;
          }
          TreeNode n=findNode(node.left,x);
          if (n!=null){
              return n;
          }
          return findNode(node.right,x);

    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        while (!que.isEmpty()){
            TreeNode left=que.poll();
            TreeNode right=que.poll();
            if (left==null && right==null){
                continue;
            }
            if (left==null || right==null){
                return false;
            }
            if (left.val != right.val ){
                return false;
            }
            que.add(left.left);
            que.add(right.right);
            que.add(left.right);
            que.add(right.left);
        }
        return true;
    }
}
