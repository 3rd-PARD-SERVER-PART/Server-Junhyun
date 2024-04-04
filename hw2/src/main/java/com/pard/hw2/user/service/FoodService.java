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
    public FoodDto findById(Integer cost){
        return foodRepository.findById(cost);
    }

    public List<FoodDto> findAll(){
        return foodRepository.findAll();
    }

    public void update(Integer cost, FoodDto foodDto){
        foodRepository.update(cost,foodDto);
    }

    public void delete(Integer cost){
        foodRepository.delete(cost);
    }
}