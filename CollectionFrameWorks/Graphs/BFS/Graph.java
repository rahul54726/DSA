package com.CollectionFrameWorks.Graphs.BFS;
import com.Rahul.encapsulation.A;

import java.util.*;

public class Graph {
    private LinkedList<Integer>[] adjList;
    int V;
    public Graph(int size){
        this.V=size;
        adjList=new LinkedList[size];
        for (int i=0;i<size;i++){
            adjList[i]=new LinkedList<>();
        }
    }
    public void addEdge(int src,int des){
        adjList[src].add(des);
        adjList[des].add(src);
    }
    public List<Integer> bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[adjList.length];
        List<Integer> result = new ArrayList<>();
        visited[start]=true;
        queue.add(start);
        while (!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            System.out.print(node+" ");
            for (int neighbors:adjList[node]){
                if(!visited[neighbors]){
                    visited[neighbors]=true;
                    queue.add(neighbors);
                }
            }
        }
        return result;
    }
    public LinkedList<Integer> bfs1(int start){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited =new boolean[adjList.length];
        LinkedList<Integer> result=new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int node=queue.poll();
            result.add(node);
            for (int neighbors : adjList[node]){
                if(!visited[neighbors]){
                    visited[neighbors]=true;
                    queue.offer(neighbors);
                }
            }
        }
        return result;
    }
    public void shortestPath(int src){
        int[] distance = new int[V];
        Arrays.fill(distance,-1);
        Queue<Integer> que=new LinkedList<>();
        que.add(src);
        distance[src]=0;
        while (!que.isEmpty()){
            int node=que.poll();
            for(int neighbor :adjList[node]){
                if (distance[neighbor] == -1){
                    distance[neighbor]=distance[node]+1;
                    que.add(neighbor);
                }
            }
        }
        for (int i=0;i<V;i++){
            System.out.println("Shortest path from " + src + " to " + i + " is " + distance[i]);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
         backTrack(graph,0,path,result);
         return result;
    }

    private void backTrack(int[][] graph, int i, List<Integer> path, List<List<Integer>> result) {
        if(i == graph.length-1){
            result.add(new ArrayList<>(path));
            return ;
        }
        for(int nodes:graph[i]){
            path.add(nodes);
            backTrack(graph,nodes,path,result);
            path.removeLast();
        }

    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int col = grid[0].length;
        int count = 0;
        int [][] directions = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<rows;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    queue.offer(new int[]{i,j});

                while (!queue.isEmpty()){
                    int[] current = queue.poll();
                    int x = current[0];
                    int y = current[1];
                    for(int[] dir : directions){
                        int newX= x + dir[0];
                        int newY = y + dir[1];
                        if(newX >=0 && newX<rows && newY >= 0 && newY <col && grid[newX][newY] == '1'){
                            grid[newX][newY] = '0';
                            queue.offer(new int[]{newX,newY});
                        }
                    }
                }
                }
            }
        }
        return count;
    }
    //cycle detection in UnWeighted graph
    public boolean isCyclic(){
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(adjList.length-1);
        visited[adjList.length-1] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbors:adjList[node]){
                if(visited[neighbors]) return true;
                else {
                    queue.offer(neighbors);
                    visited[neighbors]=true;
                }
            }
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int[] prereq:prerequisites){
            int course = prereq[0];
            int prereqCource = prereq[1];
            graph.putIfAbsent(prereqCource,new ArrayList<>());
            graph.get(prereqCource).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int processedCources = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            processedCources++;
            for(int neighbor:graph.getOrDefault(course,new ArrayList<>())){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return processedCources == numCourses;
    }
    public static void main(String[] args) {
        Graph graph=new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        graph.addEdge(2,3);
        graph.addEdge(2,4);

        graph.addEdge(3,5);

        graph.addEdge(4,5);


        graph.bfs(1);
        System.out.println();
        System.out.println(graph.bfs1(1));
        graph.shortestPath(1);
        System.out.println(graph.isCyclic());

    }

}
