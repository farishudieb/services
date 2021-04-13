
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
public class Centroid {

    private List<Double> coordinates;

    private String type;
}
