package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.model.Plant;
import com.bezkoder.springjwt.model.User;
import com.bezkoder.springjwt.model.UserPlants;
import com.bezkoder.springjwt.repository.PlantRepository;
import com.bezkoder.springjwt.repository.UserPlantsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPlantsService {

    private UserPlantsRepository userPlantsRepository;
    private SecurityService securityService;

    public UserPlantsService(UserPlantsRepository userPlantsRepository, SecurityService securityService){
        this.userPlantsRepository = userPlantsRepository;
        this.securityService = securityService;
    }

    public UserPlants get(Long id){
        return userPlantsRepository.findFirstById(id);
    }

    public UserPlants insert(UserPlants plant) {
        plant.setId(plant.getId());

        return userPlantsRepository.save(plant);
    }

    public UserPlants update(UserPlants plant) {

        return userPlantsRepository.save(plant);
    }

    public void delete(Long id) {
        boolean exists = userPlantsRepository.existsById(id);
        if (exists) {
            userPlantsRepository.deleteById(id);
        }
    }

    public List<UserPlants> findAll() {
        List<UserPlants> plants = new ArrayList<>();
        userPlantsRepository.findAllByUserId(1l).forEach(p -> plants.add(p));
        return plants;
    }
}
