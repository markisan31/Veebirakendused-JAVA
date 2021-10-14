package com.bezkoder.springjwt.controller;

import com.bezkoder.springjwt.model.Plant;

import com.bezkoder.springjwt.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> findAll() {
        return plantService.findAll();
    }

    @GetMapping("/{id}")
    public Plant get(@PathVariable("id") Long id) {
        return plantService.get(id);
    }

    @PostMapping("")
    public Plant insert(@RequestBody Plant plant) {
        Plant newPlant = plantService.insert(plant);
        return newPlant;
    }

    @PutMapping("/{id}")
    public Plant update(@RequestBody Plant plant) {
        Plant updatedPlant = plantService.update(plant);
        return updatedPlant;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        plantService.delete(id);
    }
}
