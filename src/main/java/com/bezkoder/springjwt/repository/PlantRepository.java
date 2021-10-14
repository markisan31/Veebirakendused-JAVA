package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.model.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
    Plant findFirstById(Long userId);
    List<Plant> findAllByOrderByNameAsc();
}
