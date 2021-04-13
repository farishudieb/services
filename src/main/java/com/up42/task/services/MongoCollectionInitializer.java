package com.up42.task.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.up42.task.repositories.UP42DataModelRepository;
import com.up42.task.repositories.model.generated.UP42DataModel;

@Service
public class MongoCollectionInitializer {

    @Autowired
    private UP42DataModelRepository up42DataModelRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeMongoDB(){

        up42DataModelRepository.deleteAll();
        up42DataModelRepository.saveAll(readInitialDocuments());
    }

    private List<UP42DataModel> readInitialDocuments(){

        ObjectMapper objectMapper = new ObjectMapper();
        try(final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("db.json")) {

            return objectMapper.readValue(resourceAsStream, new TypeReference<List<UP42DataModel>>() {});

        } catch (IOException e) {
            throw new IllegalStateException("Could not load resource file for DB initialization!", e);
        }
    }
}
