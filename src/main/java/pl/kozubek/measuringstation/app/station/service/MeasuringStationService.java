package pl.kozubek.measuringstation.app.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.station.mapper.MeasuringStationMapper;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;

import java.util.List;

/**
 * Obiekt <code>MeasuringStationService</code> odpowiedzialny za biznesową część działania aplikacji. Obiekt posiada 4
 * zmienne odpowiedzialne za mappowanie danych oraz interfej udostępniający możliwość połączenia z bazą. Obiekt został
 * okrazony adnotacjami odpowiedzialnymi za utworzenie konstruktora oraz zarządzanie przez kontekst spring'a.
 */
@Service
@RequiredArgsConstructor
public class MeasuringStationService {
    private final MeasuringStationMapper stationMapper;

    /**
     * Funkcja odpowiedzialna za udostępnienie stacji pomiarowej według podanego identyfikatora
     *
     * @param measuringStationId identyfikator stacji jednoznacznie identyfikujący encję w bazie danych
     * @return Stacja jakości powietrza
     */
    public MeasuringStation getMeasuringStation(Long measuringStationId) {
        return stationMapper.getMeasuringStation(measuringStationId);
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie listy stacji pomiarowych.
     *
     * @return Lista staji jakości powietrza
     */
    public List<MeasuringStation> getMeasuringStations() {
        return stationMapper.getMeasuringStations();
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie listy stacji wraz z wszystkimi informacjami na temat stacji.
     *
     * @return Lista stacji wraz z miastem oraz adresem gdzie stacja się znajduje.
     */
    public List<MeasuringStationDto> getMeasuringStationWithCityAndCommune() {
        return stationMapper.getMeasuringStationWithCityAndCommune();
    }

    /**
     * Funkcja odpowiedzialna za udostępnienie jakości powietrza z najbliższej stacji poprzez podanie lokalizacji
     * geograficznej.
     *
     * @param gegrLan Liczba lokalizacji horyzontalnej
     * @param gegrLon Liczba lokalizacji wertykalnej
     * @return Obiekt jakości powietrza z najbliższej stacji pomiarowej.
     */
    public MeasuringDataDto getStationByNearestLocalization(Long gegrLan, Long gegrLon) {
        return stationMapper.getStationByNearestLocalization(gegrLan, gegrLon);
    }
}
