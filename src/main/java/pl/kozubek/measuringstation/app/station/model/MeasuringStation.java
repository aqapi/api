package pl.kozubek.measuringstation.app.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringStation {
    private Long id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private Long city;
    private String addressStreet;
}
