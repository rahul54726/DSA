package com.LeetCode.medium;

import java.util.*;

public class TaskManager {
    Map<Integer,Task> map = new TreeMap<>();
    TreeSet<TaskKey> set;
    class Task{
        int userId;
        int priority;

        public Task(int userId, int priority) {
            this.userId = userId;
            this.priority = priority;
        }

    }
    private static class TaskKey {
        int priority;
        int taskId;
        TaskKey(int priority, int taskId) {
            this.priority = priority;
            this.taskId = taskId;
        }
    }
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        set = new TreeSet<>((a,b)-> {
            if (a.priority != b.priority) return Integer.compare(b.priority,a.priority);
            return Integer.compare(b.taskId,a.taskId);
        });
        for (List<Integer> list :tasks){
            int useId = list.get(0);
            int taskId = list.get(1);
            int priority = list.get(2);
            map.put(taskId,new Task(useId,priority));
            set.add(new TaskKey(priority,taskId));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId,priority);
        map.put(taskId,task);
        set.add(new TaskKey(priority,taskId));
    }

    public void edit(int taskId, int newPriority) {
        Task old = map.get(taskId);
        if (old == null) return;
        set.remove(new TaskKey(old.priority,taskId));
        old.priority = newPriority;
        set.add(new TaskKey(newPriority,taskId));
    }

    public void rmv(int taskId) {
        Task old = map.get(taskId);
        if (old == null) return;
        set.remove(new TaskKey(old.priority, taskId));
        map.remove(taskId);    }

    public int execTop() {
        if (set.isEmpty()) return -1;
        TaskKey tk = set.first();
        set.remove(tk);
        Task t  = map.remove(tk.taskId);
        return t.userId;
    }
}
