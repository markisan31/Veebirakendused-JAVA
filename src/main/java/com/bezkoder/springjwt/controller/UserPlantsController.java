package com.bezkoder.springjwt.controller;

import com.bezkoder.springjwt.model.Plant;
import com.bezkoder.springjwt.model.UserPlants;
import com.bezkoder.springjwt.service.PlantService;
import com.bezkoder.springjwt.service.UserPlantsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user_plants")
public class UserPlantsController {

    private UserPlantsService userPlantService;

    public UserPlantsController(UserPlantsService userPlantService) {
        this.userPlantService = userPlantService;
    }

    @GetMapping("/user/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<UserPlants> findAll(@PathVariable("id") Long id) {
        return userPlantService.findAll(id);
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("authentication.principal.equals(#userId)")
//    public UserPlants get(@PathVariable("id") Long id) {
//        return userPlantService.get(id);
//    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') and authentication.principal.equals(#userId)")
    public UserPlants insert(@RequestBody UserPlants plant) {
        UserPlants newPlant = userPlantService.insert(plant);
        return newPlant;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') and authentication.principal.equals(#userId)")
    public UserPlants update(@RequestBody UserPlants plant) {
        UserPlants updatedPlant = userPlantService.update(plant);
        return updatedPlant;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') and authentication.principal.equals(#userId)")
    public void delete(@PathVariable("id") Long id) {
        userPlantService.delete(id);
    }
}
