package pl.kozubek.measuringstation.app.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;
import pl.kozubek.measuringstation.app.station.mapper.MeasuringStationMapper;
import pl.kozubek.measuringstation.app.station.model.MeasuringCity;
import pl.kozubek.measuringstation.app.station.model.MeasuringCityCommune;
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

    public void addMeasuringStation(MeasuringStation station) {
        stationMapper.addMeasuringStation(station);
    }

    public List<MeasuringStationDto> getMeasuringStationWithCityAndCommune() {
        return stationMapper.getMeasuringStationWithCityAndCommune();
    }

    @Transactional
    public void addMeasuringStationWithCityAndCommune(MeasuringStationDto stationDto) {
        MeasuringCityCommune commune = communeDtoMapper.to(stationDto.getCity().getCommune());
        MeasuringCity city = cityDtoMapper.to(stationDto.getCity());
        MeasuringStation station = stationDtoMapper.to(stationDto);

        if (stationMapper.existCommuneByCommuneNameAndDistrictNameAndProvinceName(commune.getCommuneName(),
                commune.getDistrictName(),
                commune.getProvinceName()))
            stationMapper.addMeasuringCommune(commune);
        if (stationMapper.existCityById(city.getId())) {
            city.setCommune(commune.getId());
            stationMapper.addMeasuringCity(city);
        }
        if (stationMapper.existStationById(station.getId()))
            stationMapper.addMeasuringStation(station);
    }

    public Boolean callToGiosApi() {
        try {
            List<MeasuringStationDto> stationDtos = client.getMeasuringStation();
            for (MeasuringStationDto stationDto : stationDtos) {
                addMeasuringStationWithCityAndCommune(stationDto);
                MeasuringDataDto dataDto = client.getData(stationDto.getId());
                dataService.addMeasuringDataWithValue(dataDto);
            }
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
