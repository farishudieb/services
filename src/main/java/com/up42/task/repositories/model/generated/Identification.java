
package com.up42.task.repositories.model.generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Identification {

    private String collection;
    
    private Dataset dataset;
    
    private String externalId;
    
    private String profile;
    
    private String type;
}
