package com.real.estate.backend.service;

import com.real.estate.backend.model.PropertyInformation;
import com.real.estate.backend.repository.PropertyInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyInformationService {

    @Autowired
    private PropertyInformationRepository propertyInformationRepository;

    public PropertyInformation save(PropertyInformation propertyInformation) {
        return propertyInformationRepository.save(propertyInformation);
    }

    public PropertyInformation getPropertyInformation(Long id) {
        Optional<PropertyInformation> propertyInformation = propertyInformationRepository.findById(id);
        if(propertyInformation.isPresent()) {
            return propertyInformation.get();
        }
        return null;
    }

    public List<PropertyInformation> getPropertiesByType(String type) {
        List<PropertyInformation> propertyInformations = propertyInformationRepository.findPropertyInformationByType(type);
        if(propertyInformations != null && propertyInformations.size() > 0) {
            return propertyInformations;
        }
        return null;
    }

    public Boolean deletePropertyById(Long id) {
        Optional<PropertyInformation> propertyInformation = propertyInformationRepository.findById(id);
        if(propertyInformation.isPresent()) {
            propertyInformationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public PropertyInformation updatePropertyInformation(Long id, PropertyInformation propertyInformation){
        Optional<PropertyInformation> propertyInformationOptional = propertyInformationRepository.findById(id);
        if(propertyInformationOptional.isPresent()) {
            PropertyInformation propertyInformationFromDB = propertyInformationOptional.get();
            propertyInformationFromDB.setTitle(propertyInformation.getTitle());
            propertyInformationFromDB.setDescription(propertyInformation.getDescription());
            propertyInformationFromDB.setType(propertyInformation.getType());
            propertyInformationFromDB.setCoverImage(propertyInformation.getCoverImage());
            return propertyInformationRepository.save(propertyInformationFromDB);
        }
        return null;
    }

}
