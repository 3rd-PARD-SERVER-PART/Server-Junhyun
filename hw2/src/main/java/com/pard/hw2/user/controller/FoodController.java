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
    public void saveUser(@RequestBody FoodDto foodDto){
        foodService.saveFood(foodDto);
    }

    @GetMapping("/{cost}")
    public FoodDto findById(@PathVariable Integer cost){
        return foodService.findById(cost);
    }

    @GetMapping("")
    public List<FoodDto> findAll(){
        return foodService.findAll();
    }

    @PatchMapping("/{cost}")
    public void update(@PathVariable Integer cost,@RequestBody FoodDto foodDto){
        foodService.update(cost,foodDto);
    }

    @DeleteMapping("/{cost}")
    public void delete(@PathVariable Integer cost){
        foodService.delete(cost);
    }

}
