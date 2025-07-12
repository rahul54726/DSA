package com.LeetCode.AdvanvcedTreeQuestions;

import com.Array.Array;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public  TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
//    static int index=0;
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        if (preOrder.length == 0) return null;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return helper(preOrder,inOrder,0,preOrder.length-1,map);
    }
int index =0;
    private TreeNode helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map) {
        if(left > right) return null;
        int current = preOrder[index];
        index++;
        TreeNode node = new TreeNode(current);
        if (left==right) return node;
        int inoderIndex=map.get(current);
        node.left=helper(preOrder,inOrder,left,inoderIndex-1,map);
        node.left=helper(preOrder,inOrder,inoderIndex+1,right,map);
        return node;
    }
            //BFS
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root == null) return null;
        int col=0;
        Queue<Map.Entry<TreeNode,Integer>> queue=new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root,col));
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()){
            Map.Entry<TreeNode,Integer> current=queue.poll();
            root = current.getKey();
            col=current.getValue();
            if(root != null){
                if(!map.containsKey(col)){
                    map.put(col,new ArrayList<Integer>());
                }
                map.get(col).add(root.val);
                min = Math.min(min,col);
                max= Math.max(max,col);

                queue.offer(new AbstractMap.SimpleEntry<>(root.left,col-1));
                queue.offer(new AbstractMap.SimpleEntry<>(root.right,col+1));
            }
        }
        for (int i = min ;i<=max;i++){
            result.add(map.get(i));
        }
        return  result;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>(wordList);
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size =queue.size();
            count++;
            for(int i = 0;i<size;i++){
                String current = queue.poll();

                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char ch = 'a';ch<'z';ch++){
                        temp[j] = ch;
                        String newWord=new String(temp);
                        if(newWord.equals(endWord)) {
                            return count + 1;
                        }
                        if (wordList.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set= new HashSet<>();
         return helper(root,set,k);
    }
    private boolean helper(TreeNode root,Set<Integer> set,int k){
        if(root == null) return false;
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return helper(root.left,set,k) || helper(root.right,set,k);
    }

}
