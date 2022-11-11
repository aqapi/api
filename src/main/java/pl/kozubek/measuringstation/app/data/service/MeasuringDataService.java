package pl.kozubek.measuringstation.app.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kozubek.measuringstation.app.data.mapper.MeasuringDataMapper;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringDataService {
    private final MeasuringDataMapper dataMapper;

    public List<MeasuringData> getData() {
        return dataMapper.getData();
    }

    public MeasuringDataDto getDataWithValue() {
        return dataMapper.getDataWithValue();
    }
}
