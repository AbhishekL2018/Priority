package com.abhishek.priority.repository;

import com.abhishek.priority.model.PriorityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityModel, Integer> {

    Optional<PriorityModel> findByPriorityNameAndDeleted(String priorityName, boolean deleted);
}
