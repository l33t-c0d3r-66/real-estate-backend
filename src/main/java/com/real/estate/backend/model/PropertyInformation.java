package com.real.estate.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String title;
    private Integer price;
    private String description;
    private Integer numberOfBedRooms;
    private Integer numberOfBathrooms;
    private Integer areaInSquareFts;
    private String location;
    private String coverImage;


}
