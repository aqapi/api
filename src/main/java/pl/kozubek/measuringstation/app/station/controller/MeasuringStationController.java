package pl.kozubek.measuringstation.app.station.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.LocalizationDto;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.app.station.service.MeasuringStationService;

import java.util.List;

/**
 * Klasa odpowiedzialna za udostępnianie endpointów poprzez które można uzyskać informację na temat stacji jakości
 * powietrza z bazy danych. Funkcja okraszona jest atrybutami odpowiedzialnymi za utworzenie konstruktorów oraz
 * zarządzaniem przez kontekst spring'a. Klasa również udostępnia wszystkie swoje endpointy pod adresem /station/**.
 */
@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class MeasuringStationController {

    private final MeasuringStationService stationService;

    /**
     * Funkcja odpowiedzialna za udostępnienie listy stacji pomiarowych. Funkcja korzysta z
     * procedury GET.
     *
     * @return Lista staji jakości powietrza
     */
    @GetMapping()
    public List<MeasuringStation> getMeasuringStations() {
        return stationService.getMeasuringStations();
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie listy stacji wraz z wszystkimi informacjami na temat stacji. Funkcja
     * korzysta z procedury GET oraz jest dostępna pod adresem /station/all.
     *
     * @return Lista stacji wraz z miastem oraz adresem gdzie stacja się znajduje.
     */
    @GetMapping("/all")
    public List<MeasuringStationDto> getMeasuringStation() {
        return stationService.getMeasuringStationWithCityAndCommune();
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie stacji pomiarowej według podanego identyfikatora. Funkcja
     * korzysta z procedury GET oraz jest dostępna pod adresem /station/{id}, gdzie jako parametr podaje się id stacji.
     *
     * @param id identyfikator stacji jednoznacznie identyfikujący encję w bazie danych
     * @return Stacja jakości powietrza
     */
    @GetMapping("/{measuringStationId}")
    public MeasuringStation getMeasuringStation(@PathVariable("measuringStationId") Long id) {
        return stationService.getMeasuringStation(id);
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie jakości powietrza z najbliższej stacji poprzez podanie lokalizacji
     * geograficznej. Funkcja korzysta z procedury GET oraz jest dostępna pod adresem /station/nearestStation.
     *
     * @param localization Obiekt przechowujący długość i szerokość geograficzną.
     * @return Obiekt jakości powietrza z najbliższej stacji pomiarowej.
     */
    @GetMapping("/nearestStation")
    public MeasuringDataDto getStationByNearestLocalization(LocalizationDto localization) {
        return stationService.getStationByNearestLocalization(localization.gegrLan(), localization.gegrLon());
    }
}
