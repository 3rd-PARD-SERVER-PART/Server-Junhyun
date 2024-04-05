package com.pard.hw2.user.service;

import com.pard.hw2.user.dto.FoodDto;
import com.pard.hw2.user.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FoodService {
    private final FoodRepository foodRepository;

    public void saveFood(FoodDto foodDto){
        foodRepository.saveFood(foodDto);
    }
    public FoodDto findById(Integer foodId){
        return foodRepository.findById(foodId);
    }

    public List<FoodDto> findAll(){
        return foodRepository.findAll();
    }

    public void update(Integer foodId, FoodDto foodDto){
        foodRepository.update(foodId,foodDto);
    }

    public void delete(Integer foodId){
        foodRepository.delete(foodId);
    }
}