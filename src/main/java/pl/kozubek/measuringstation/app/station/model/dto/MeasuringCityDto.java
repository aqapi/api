package pl.kozubek.measuringstation.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCityDto {
    private Long id;
    private String cityName;
    private MeasuringCityCommuneDto commune;
}
