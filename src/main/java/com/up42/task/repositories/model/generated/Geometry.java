
package com.up42.task.repositories.model.generated;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geometry {

    private CenterPoint centerPoint;
    
    private List<List<List<Double>>> coordinates;
    
    private GeographicBoundingPolygon geographicBoundingPolygon;
    
    private Boolean global;
    
    private String type;
}
