package com.jwtwithrole.repository;

import com.jwtwithrole.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByUsername(String username);

    public Boolean existsByUsername(String username);

}
