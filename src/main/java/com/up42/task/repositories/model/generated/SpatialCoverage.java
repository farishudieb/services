
package com.up42.task.repositories.model.generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpatialCoverage {

    private Geometry geometry;

    private Verticality verticality;
}
