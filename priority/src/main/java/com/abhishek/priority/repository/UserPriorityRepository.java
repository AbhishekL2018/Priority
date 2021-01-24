package com.abhishek.priority.repository;

import com.abhishek.priority.model.UserPriorityMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPriorityRepository extends JpaRepository<UserPriorityMapping, Integer> {
    Optional<UserPriorityMapping> findByUserIdAndPriorityIdAndDeleted(long userId, long priorityId, boolean deleted);

    List<UserPriorityMapping> findAllByUserIdAndDeleted(long userId, boolean deleted);

    Optional<UserPriorityMapping> findFirstByUserIdAndDeleted(long userId, boolean deleted);
}
