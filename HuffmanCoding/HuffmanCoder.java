package com.HuffmanCoding;
import com.CollectionFrameWorks.Heap.Heaps;
import java.util.*;
public class HuffmanCoder {
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;
    public HuffmanCoder(String feeder) throws Exception{
        HashMap<Character,Integer> fmap=new HashMap<>();
//        for(int i=0;i<feeder.length();i++){
//            char cc=feeder.charAt(i);
//            if (fmap.containsKey(cc)){
//                int ov=fmap.get(cc);
//                ov+=1;
//                fmap.put(cc,ov);
//            }
//
//        }
            for(char ch:feeder.toCharArray()){
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            Heaps<Node> minHeap=new Heaps<>();
            Set< Map.Entry<Character,Integer>> entrySet=fmap.entrySet();

           for (Map.Entry<Character,Integer> entry:entrySet){
               Node node=new Node(entry.getKey(),entry.getValue());
               minHeap.insert(node);
           }
           while (minHeap.size()!=1){
               Node first = minHeap.remove();
               Node second=minHeap.remove();

               Node newNode=new Node(null, first.cost+second.cost);
               newNode.left=first;
               newNode.right=second;
               minHeap.insert(newNode);
           }
           Node ft=minHeap.remove();
           this.encoder=new HashMap<>();
           this.decoder=new HashMap<>();
           this.initEncoderDecoder(ft,"");
            }

    private void initEncoderDecoder(Node node, String osf) {
        if (node ==null){
            return;
        }
        if (node.left==null && node.right==null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left,osf+"0");
        initEncoderDecoder(node.right,osf+"1");
    }
    public String encode(String src){
            StringBuilder ans= new StringBuilder();
            for (int i=0;i<src.length();i++){
                ans.append(encoder.get(src.charAt(i)));
            }

            return ans.toString();
    }
    public String decode(String codedString){
        String key="";
        StringBuilder ans= new StringBuilder();
        for (int i=0;i<codedString.length();i++){
            key=key+codedString.charAt(i);
            if (decoder.containsKey(key)){
                ans.append(decoder.get(key));
                key="";
            }
        }
        return ans.toString();
    }
    private  class Node implements Comparable<Node>{
        Character data;
        int cost; // frequency
        Node left;
        Node right;
        public Node(Character data,int cost){
            this.cost=cost;
            this.data=data;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}
