package com.up42.task.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureResponse {

    private String featureId;

    private String timestamp;

    private Long beginViewingDate;

    private Long endViewingDate;

    private String missionName;
}
