package pl.kozubek.measuringstation.app.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class MeasuringDataController {

    private final MeasuringDataService dataService;

    @GetMapping()
    public List<MeasuringData> getData() {
        return dataService.getData();
    }

    @GetMapping("/all")
    public MeasuringDataDto getDataWithValue() {
        return dataService.getDataWithValue();
    }
}