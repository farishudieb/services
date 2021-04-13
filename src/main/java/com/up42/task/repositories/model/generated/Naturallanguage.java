
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
public class Naturallanguage {

    @JsonAlias("search_cloud_string")
    private String searchCloudString;

    @JsonAlias("search_date_string")
    private String searchDateString;

    @JsonAlias("search_incidence_angle_string")
    private String searchIncidenceAngleString;

    @JsonAlias("search_quality_string")
    private String searchQualityString;
}
