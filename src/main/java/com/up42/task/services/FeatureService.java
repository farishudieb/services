package com.up42.task.services;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up42.task.api.FeatureResponse;
import com.up42.task.repositories.UP42DataModelRepository;
import com.up42.task.repositories.model.generated.Acquisition;
import com.up42.task.repositories.model.generated.UP42DataModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeatureService {

    private final UP42DataModelRepository up42DataModelRepository;

    public Optional<FeatureResponse> getFeatureById(String id){

        final Optional<UP42DataModel> optionalFeature = up42DataModelRepository.findByFeatureId(id);
        if(optionalFeature.isPresent())
            return optionalFeature.map(this::mapToClient);

        return Optional.empty();
    }

    public List<FeatureResponse> getAllFeatures(){

        return up42DataModelRepository
                .findAll()
                .stream()
                .map(this::mapToClient)
                .collect(Collectors.toList());
    }

    public byte[] getPreviewForFeature(String id){

        final Optional<UP42DataModel> optionalUP42DataModel = up42DataModelRepository.findByFeatureId(id);
        if(optionalUP42DataModel.isPresent()){

            final String quickLook = optionalUP42DataModel.get().getFeatures().get(0).getProperties().getQuickLook();
            return Base64.getDecoder().decode(quickLook);
        }

        return null;
    }

    private FeatureResponse mapToClient(UP42DataModel model){

        final Acquisition acquisition = model.getFeatures().get(0).getProperties().getAcquisition();

        return FeatureResponse
                .builder()
                .beginViewingDate(acquisition.getBeginViewingDate())
                .endViewingDate(acquisition.getEndViewingDate())
                .missionName(acquisition.getMissionName())
                .timestamp(model.getFeatures().get(0).getProperties().getTimestamp())
                .featureId(model.getFeatures().get(0).getProperties().getId())
                .build();
    }
}
