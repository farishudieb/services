
package com.up42.task.repositories.model.generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orbit {

    private String direction;

    private Long relativeNumber;
}
