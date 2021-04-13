
package com.up42.task.repositories.model.generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Archive {

    private Boolean offLine;
    
    private Boolean onLine;
    
    private Long size;
}
