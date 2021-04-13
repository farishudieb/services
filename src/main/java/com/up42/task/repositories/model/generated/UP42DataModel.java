package com.up42.task.repositories.model.generated;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "up42-feature-metadata")
public class UP42DataModel {

    private String id;

    private List<Feature> features;

    private String type;
}
