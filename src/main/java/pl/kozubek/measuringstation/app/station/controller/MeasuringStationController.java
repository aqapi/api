package pl.kozubek.measuringstation.app.station.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.app.station.service.MeasuringStationService;
import pl.kozubek.measuringstation.webClient.MeasuringClient;

import java.util.List;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class MeasuringStationController {

    private final MeasuringStationService stationService;
    private final MeasuringClient client;
    private final MeasuringDataService dataService;

    @GetMapping()
    public List<MeasuringStation> getMeasuringStations() {
        return stationService.getMeasuringStations();
    }

    @GetMapping("/all")
    public List<MeasuringStationDto> getMeasuringStation() {
        return stationService.getMeasuringStationWithCityAndCommune();
    }

    @GetMapping("/{measuringStationId}")
    public MeasuringStation getMeasuringStation(@PathVariable("measuringStationId") Long id) {
        return stationService.getMeasuringStation(id);
    }

    @PostMapping
    public void addMeasuringStation(@RequestBody MeasuringStationDto station) {
        stationService.addMeasuringStationWithCityAndCommune(station);
    }

    @GetMapping("/dataAndStation")
    public void callToGiosApi() {
        List<MeasuringStationDto> stationDtos = client.getMeasuringStation();
        for (MeasuringStationDto stationDto : stationDtos) {
            stationService.addMeasuringStationWithCityAndCommune(stationDto);
            MeasuringDataDto dataDto = client.getData(stationDto.getId());
            dataService.addMeasuringDataWithValue(dataDto);
        }
    }
}
