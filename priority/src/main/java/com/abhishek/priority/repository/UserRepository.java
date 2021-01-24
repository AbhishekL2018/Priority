package com.abhishek.priority.repository;

import com.abhishek.priority.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUserNameAndDeleted(String userName, boolean deleted);
}
