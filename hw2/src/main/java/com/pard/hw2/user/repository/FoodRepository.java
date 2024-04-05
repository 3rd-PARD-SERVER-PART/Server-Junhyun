package com.pard.hw2.user.repository;

import com.pard.hw2.user.Food;
import com.pard.hw2.user.dto.FoodDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //파일이 저장소 역할을 할거라는걸 알려줌
public class FoodRepository {
    private static final Map<Integer, Food> handong = new HashMap<>();

    // Create

    public void saveFood(FoodDto foodDto){
        Food f = Food.builder()
                .foodId(foodDto.getFoodId())
                .foodName(foodDto.getFoodName())
                .cost(foodDto.getCost())
                .size(foodDto.getSize())
                .build();
        handong.put(foodDto.getFoodId(),f);
    }

    // Read
    public FoodDto findById(Integer foodId){
        Food food = handong.get(foodId);
        return FoodDto.builder()
                .foodId(food.getFoodId())
                .cost(food.getCost())
                .foodName(food.getFoodName())
                .size(food.getSize())
                .build();
    }
    public List<FoodDto> findAll(){
        return handong.values().stream()
                .map(food -> FoodDto.builder()
                        .foodId(food.getFoodId())
                        .cost(food.getCost())
                        .foodName(food.getFoodName())
                        .size(food.getSize())
                        .build()).toList();
    }

    //UPDATE

    public void update(Integer foodId, FoodDto foodDto){
        Food food = handong.get(foodId);
        food.setCost(foodDto.getCost());
        food.setFoodId(foodDto.getCost());
        food.setFoodName(foodDto.getFoodName());
        food.setSize(foodDto.getSize());
//        handong.put(user.getStudentId(),user);
    }

    // DELETE

    public void delete(Integer foodId){
        handong.remove(foodId);
    }
}