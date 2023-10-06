package com.real.estate.backend.controller;

import com.real.estate.backend.model.PropertyInformation;
import com.real.estate.backend.service.PropertyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PropertyController {

    @Autowired
    private PropertyInformationService propertyInformationService;


    @GetMapping("/api/public/properties/{type}")
    public List<PropertyInformation> getPropertiesByType(@PathVariable("type") String type) {
        List<PropertyInformation> properties = propertyInformationService.getPropertiesByType(type);
        if(properties != null) {
            return properties;
        }
        return new ArrayList<>();
    }

    @GetMapping("/api/public/property/{id}")
    public PropertyInformation getPropertyById(@PathVariable("id") Long id) {
        return propertyInformationService.getPropertyInformation(id);
    }

    @PostMapping("/api/v1/property")
    public PropertyInformation saveProperty(@RequestBody PropertyInformation propertyInformation) {
        return propertyInformationService.save(propertyInformation);
    }

    @PutMapping("/api/v1/property/{id}")
    public PropertyInformation updateProperty(@PathVariable("id") Long id, PropertyInformation propertyInformation) {
        return propertyInformationService.updatePropertyInformation(id, propertyInformation);
    }

    @DeleteMapping("/api/v1/property/{id}")
    public String deletePropertyInformation(@PathVariable("id") Long id) {
        Boolean isDeleted = propertyInformationService.deletePropertyById(id);
        if(isDeleted) {
            return "Property Deleted Successfully";
        }
        return "Failed to Delete the Property";
    }
}
