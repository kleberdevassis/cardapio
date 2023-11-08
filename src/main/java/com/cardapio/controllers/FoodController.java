package com.cardapio.controllers;

import com.cardapio.food.Food;
import com.cardapio.food.FoodRepository;
import com.cardapio.food.FoodRequestDTO;
import com.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
      repository.save(foodData);
      return;
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream()
                 .map(FoodResponseDTO::new).toList();
        return foodList;
    }

}
