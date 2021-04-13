package com.up42.task.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.up42.task.repositories.model.generated.UP42DataModel;

public interface UP42DataModelRepository extends MongoRepository<UP42DataModel, String> {

    @Query("{'features.properties.id' : ?0}")
    Optional<UP42DataModel> findByFeatureId(String featureId);
}
