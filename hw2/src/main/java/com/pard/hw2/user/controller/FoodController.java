package com.pard.hw2.user.controller;

import com.pard.hw2.user.Food;
import com.pard.hw2.user.dto.FoodDto;
import com.pard.hw2.user.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @PostMapping("")
    public String saveUser(@RequestBody FoodDto foodDto){
        foodService.saveFood(foodDto);
        return "success";
    }

    @GetMapping("/{foodId}")
    public FoodDto findById(@PathVariable Integer foodId){
        return foodService.findById(foodId);
    }

    @GetMapping("")
    public List<FoodDto> findAll(){
        return foodService.findAll();
    }

    @PatchMapping("/{foodId}")
    public FoodDto update(@PathVariable Integer foodId,@RequestBody FoodDto foodDto){
        foodService.update(foodId,foodDto);
        return foodService.findById(foodId);
    }

    @DeleteMapping("/{foodId}")
    public String delete(@PathVariable Integer foodId){
        foodService.delete(foodId);
        return "success";
    }

}