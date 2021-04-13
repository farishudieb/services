package com.up42.task.repositories.model.generated;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Properties {
    
    private Acquisition acquisition;
    
    private Archive archive;
    
    private Attitude attitude;
    
    private Centroid centroid;
    
    private ContentDescription contentDescription;
    
    private Enrichment enrichment;
    
    private String id;
    
    private Identification identification;
    
    private Illumination illumination;
    
    private Orbit orbit;
    
    private Production production;
    
    private SpatialCoverage spatialCoverage;
    
    private State state;

    private String timestamp;

    private Transmission transmission;
    
    private String uid;
    
    private Visibility visibility;

    @JsonAlias("quicklook")
    private String quickLook;

    private Quality quality;

    private Target target;

    private Provider provider;
}
