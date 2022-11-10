package pl.kozubek.measuringstation.app.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kozubek.measuringstation.app.station.mapper.MeasuringStationMapper;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringStationService {
    private final MeasuringStationMapper stationMapper;

    public MeasuringStation getMeasuringStation(Long measuringStationId) {
        return stationMapper.getMeasuringStation(measuringStationId);
    }

    public List<MeasuringStation> getMeasuringStations() {
        return stationMapper.getMeasuringStations();
    }

    public void addMeasuringStation(MeasuringStation station) {
        stationMapper.addMeasuringStation(station);
    }
}
