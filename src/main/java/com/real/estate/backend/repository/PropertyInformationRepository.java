package com.real.estate.backend.repository;

import com.real.estate.backend.model.PropertyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyInformationRepository extends JpaRepository<PropertyInformation, Long> {
    public List<PropertyInformation> findPropertyInformationByType(String type);
}