
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
public class State {

    private Resources resources;

    private String name;

    private Services services;

    private String insertionDate;

    private List<County> counties;
}
