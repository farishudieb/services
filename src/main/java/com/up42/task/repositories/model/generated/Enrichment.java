
package com.up42.task.repositories.model.generated;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrichment {

    @JsonAlias("geonames")
    private List<GeoName> geoNames;

    private Naturallanguage naturallanguage;
}
