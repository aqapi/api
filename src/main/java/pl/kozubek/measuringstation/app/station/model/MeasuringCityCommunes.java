package pl.kozubek.measuringstation.app.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCityCommunes {
    private Long id;
    private String communeName;
    private String districtName;
    private String provinceName;
}
