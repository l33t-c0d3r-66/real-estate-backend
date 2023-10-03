package com.real.estate.backend.repository;

import com.real.estate.backend.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,  Long> {
    Optional<UserInformation> findByEmail(String email);
}
