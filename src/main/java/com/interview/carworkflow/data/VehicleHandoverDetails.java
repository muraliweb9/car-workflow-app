package com.interview.carworkflow.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleHandoverDetails {
    private boolean isClean;
    private boolean hasFuel;
    private boolean hasExteriorBeenChecked;

    public boolean allChecksDone() {
        return isClean() && isHasFuel() && isHasExteriorBeenChecked();
    }
}
