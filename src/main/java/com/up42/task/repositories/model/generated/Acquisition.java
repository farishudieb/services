
package com.up42.task.repositories.model.generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acquisition {

    private Long beginViewingDate;

    private Long endViewingDate;

    private String mission;

    private String missionCode;

    private String missionId;

    private String missionName;

    private String polarization;

    private String sensorId;

    private String sensorMode;
}
