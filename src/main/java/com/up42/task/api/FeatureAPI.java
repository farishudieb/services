package com.up42.task.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.up42.task.services.FeatureService;

@RestController
public class FeatureAPI {

    @Autowired
    private FeatureService featureService;

    @GetMapping(
            path = "/features",
            produces = "application/json")
    public ResponseEntity<List<FeatureResponse>> getAllFeatures(){

        return ResponseEntity.ok(featureService.getAllFeatures());
    }

    @GetMapping(
            path = "/features/{id}",
            produces = "application/json")
    public ResponseEntity<FeatureResponse> getFeature(@PathVariable String id){

        final Optional<FeatureResponse> optionalFeature = featureService.getFeatureById(id);

        if(optionalFeature.isPresent())
            return ResponseEntity.ok(optionalFeature.get());
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping(
            path = "/features/{id}/quicklook",
            produces = "image/png")
    public ResponseEntity<byte[]> getFeaturePreview(@PathVariable String id){

        final byte[] previewForFeature = featureService.getPreviewForFeature(id);
        if(previewForFeature == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(previewForFeature);
    }
}
