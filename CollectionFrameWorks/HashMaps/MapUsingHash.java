package com.CollectionFrameWorks.HashMaps;

public class MapUsingHash {
    private Entity[] entities;

    public MapUsingHash() {
        entities=new Entity[100];
    }
    public  void put(String key,String value){
        int hash=Math.abs(key.hashCode()%entities.length);
        entities[hash]=new Entity(key,value); //overridding
    }
    public String get(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if (entities[hash]!=null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }
    public void remove(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if (entities[hash]!=null && entities[hash].key.equals(key)){
            entities[hash]=null;
        }
    }
    private class Entity{
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MapUsingHash map=new MapUsingHash();
        map.put("Rahul","22");
        map.put("Raj","21");
        map.put("Priyanshu","20");
        map.put("Rohit","29");
        System.out.println(map.get("Priyanshu"));
        map.remove("Rohit");
        System.out.println(map.get("Rohit"));
    }
}
