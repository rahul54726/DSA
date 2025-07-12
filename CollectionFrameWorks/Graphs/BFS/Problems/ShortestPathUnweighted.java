package com.CollectionFrameWorks.Graphs.BFS.Problems;
import java.util.*;

public class ShortestPathUnweighted {
    private Map<Integer,List<Integer>> adj;
    public ShortestPathUnweighted(){
        adj=new HashMap<>();
    }
    public void addEdge(int src,int des){
        adj.computeIfAbsent(src,k->new ArrayList<>()).add(des);
        adj.computeIfAbsent(des,k->new ArrayList<>()).add(src);
    }
    // find the shortest path from the Source Node
    public Map<Integer,Integer> shortestPath(int start){
        Map<Integer,Integer> distace=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        queue.add(start);
        visited.add(start);
        distace.put(start,0); // distance to itself is zero
        while (!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbor:adj.getOrDefault(node,new ArrayList<>())){
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                    distace.put(neighbor,distace.get(node)+1);
                }
            }
        }
        return distace;
    }
    public static void main(String[] args) {
        ShortestPathUnweighted graph=new ShortestPathUnweighted();
        graph.addEdge(1,2);

        graph.addEdge(0,1);
        graph.addEdge(0,3);

        graph.addEdge(3,4);
        graph.addEdge(3,7);

        graph.addEdge(4,5);
        graph.addEdge(4,7);
        graph.addEdge(4,6);

        graph.addEdge(5,6);

        graph.addEdge(6,7);
        System.out.println("Shortest distance from node 2: ");
        Map<Integer,Integer> distance= graph.shortestPath(2);
        for (int nodes : distance.keySet()){
            System.out.println("Node "+nodes+" -> Distance " + distance.get(nodes));
        }


    }
}
