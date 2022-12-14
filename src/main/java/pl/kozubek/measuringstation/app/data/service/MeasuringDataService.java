package pl.kozubek.measuringstation.app.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kozubek.measuringstation.app.data.mapper.MeasuringDataMapper;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;

import java.util.List;

/**
 * Obiekt <code>MeasuringDataService</code> odpowiedzialny za biznesową część działania aplikacji. Obiekt posiada 3
 * zmienne odpowiedzialne za mappowanie danych oraz interfej udostępniający możliwość połączenia z bazą. Obiekt został
 * okrazony adnotacjami odpowiedzialnymi za utworzenie konstruktora oraz zarządzanie przez kontekst spring'a.
 */
@Service
@RequiredArgsConstructor
public class MeasuringDataService {
    private final MeasuringDataMapper dataMapper;

    /**
     * Funkcja udostępnia listę wszystkich dostępnych danych z wszystkich stacji pogodowych w kraju.
     *
     * @return Lista danych jakości powietrza.
     */
    public List<MeasuringData> getData() {
        return dataMapper.getData();
    }

    /**
     * Funkcja udostępnia dane bez identyfikatora.
     *
     * @return Dane jakości powietrza bez identyfikatora.
     */
    public MeasuringDataDto getDataWithValue() {
        return dataMapper.getDataWithValue();
    }

    /**
     * Funkcja udostępnia dane z konkretnej stacji jakości powietrza poprzez podanie identyfikatora stacji.
     *
     * @param id identyfikator stacji jednoznacznie identyfikujący encję.
     * @return Dane jakości powietrza z stacji jakości powietrza.
     */
    public MeasuringDataDto getMeasuringData(Long id) {
        return dataMapper.getMeasuringData(id);
    }
}
