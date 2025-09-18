package com.LeetCode.medium;

import java.util.*;

public class FoodRatings {
    HashMap<String,Integer> foodRating = new HashMap<>();
    HashMap<String,String> foodCuisinesMap = new HashMap<>();
    HashMap<String, TreeSet<FoodEntry>> cuisineRating = new HashMap<>();
    class FoodEntry{
        int rating;
        String food;
        FoodEntry(int rating,String food){
            this.rating= rating;
            this.food = food;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i],ratings[i]);
            foodCuisinesMap.put(foods[i],cuisines[i]);
            cuisineRating.computeIfAbsent(cuisines[i],k -> new TreeSet<>((a,b) -> {
                if (a.rating != b.rating){
                    return b.rating - a.rating;
                }
                return a.food.compareTo(b.food);
            })).add(new FoodEntry(ratings[i],foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisinesMap.get(food);
        TreeSet<FoodEntry> set = cuisineRating.get(cuisine);
        set.remove(new FoodEntry(foodRating.get(food),food));
        foodRating.put(food,newRating);
        set.add(new FoodEntry(newRating,food));
    }

    public String highestRated(String cuisine) {
        return cuisineRating.get(cuisine).first().food;
    }

}
