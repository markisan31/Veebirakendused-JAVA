package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.model.Plant;
import com.bezkoder.springjwt.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {
    private PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    public Plant get(Long id){
        return plantRepository.findFirstById(id);
    }

    public Plant insert(Plant plant) {
        plant.setId(plant.getId());

        return plantRepository.save(plant);
    }

    public Plant update(Plant plant) {

        return plantRepository.save(plant);
    }

    public void delete(Long id) {
        boolean exists = plantRepository.existsById(id);
        if (exists) {
            plantRepository.deleteById(id);
        }
    }

    public List<Plant> findAll() {
        List<Plant> plants = new ArrayList<>();
        plantRepository.findAllByOrderByNameAsc().forEach(p -> plants.add(p));
        return plants;
    }
}
