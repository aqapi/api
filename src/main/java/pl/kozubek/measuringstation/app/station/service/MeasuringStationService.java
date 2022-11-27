package pl.kozubek.measuringstation.app.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;
import pl.kozubek.measuringstation.app.station.mapper.MeasuringStationMapper;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.app.station.service.mapper.CityDtoMapper;
import pl.kozubek.measuringstation.app.station.service.mapper.CommuneDtoMapper;
import pl.kozubek.measuringstation.app.station.service.mapper.StationDtoMapper;
import pl.kozubek.measuringstation.webClient.MeasuringClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringStationService {
    private final MeasuringStationMapper stationMapper;
    private final StationDtoMapper stationDtoMapper;
    private final CityDtoMapper cityDtoMapper;
    private final CommuneDtoMapper communeDtoMapper;
    private final MeasuringClient client;
    private final MeasuringDataService dataService;

    public MeasuringStation getMeasuringStation(Long measuringStationId) {
        return stationMapper.getMeasuringStation(measuringStationId);
    }

    public List<MeasuringStation> getMeasuringStations() {
        return stationMapper.getMeasuringStations();
    }

    public List<MeasuringStationDto> getMeasuringStationWithCityAndCommune() {
        return stationMapper.getMeasuringStationWithCityAndCommune();
    }

    public MeasuringDataDto getStationByNearestLocalization(Long gegrLan, Long gegrLon) {
        return stationMapper.getStationByNearestLocalization(gegrLan, gegrLon);
    }
}
