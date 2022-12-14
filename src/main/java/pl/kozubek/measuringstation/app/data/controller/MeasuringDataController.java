package pl.kozubek.measuringstation.app.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;

import java.util.List;

/**
 * Klasa odpowiedzialna za udostępnianie endpointów poprzez które można uzyskać informację na temat jakości powietrza
 * z bazy danych. Funkcja okraszona jest atrybutami odpowiedzialnymi za utworzenie konstruktorów oraz zarządzaniem
 * przez kontekst spring'a. Klasa również udostępnia wszystkie swoje endpointy pod adresem /data/**.
 */
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class MeasuringDataController {

    private final MeasuringDataService dataService;

    /**
     * Funkcja udostępnia listę wszystkich dostępnych danych z wszystkich stacji pogodowych w kraju.
     *
     * @return Lista danych jakości powietrza.
     */
    @GetMapping()
    public List<MeasuringData> getData() {
        return dataService.getData();
    }

    /**
     * Funkcja udostępnia dane bez identyfikatora.
     *
     * @return Dane jakości powietrza bez identyfikatora.
     */
    @GetMapping("/all")
    public MeasuringDataDto getDataWithValue() {
        return dataService.getDataWithValue();
    }

    /**
     * Funkcja udostępnia dane z konkretnej stacji jakości powietrza poprzez podanie identyfikatora stacji.
     *
     * @param id identyfikator stacji jednoznacznie identyfikujący encję.
     * @return Dane jakości powietrza z stacji jakości powietrza.
     */
    @GetMapping("/measuringData/{id}")
    public MeasuringDataDto getMeasuringData(@PathVariable("id") Long id) {
        return dataService.getMeasuringData(id);
    }
}
