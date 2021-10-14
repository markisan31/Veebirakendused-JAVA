package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.model.Plant;
import com.bezkoder.springjwt.model.UserPlants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserPlantsRepository extends CrudRepository<UserPlants, Long> {
    UserPlants findFirstById(Long userId);
    List<UserPlants> findAllByOrderByNameAsc();
    List<UserPlants> findAllByUserId(Long userId);
}
