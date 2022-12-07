package pl.kozubek.measuringstation.app.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kozubek.measuringstation.app.data.mapper.MeasuringDataMapper;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.MeasuringValue;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.mapper.DataDtoMapper;
import pl.kozubek.measuringstation.app.data.service.mapper.ValueDtoMapper;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MeasuringDataService {
    private final MeasuringDataMapper dataMapper;
    private final DataDtoMapper dataDtoMapper;
    private final ValueDtoMapper valueDtoMapper;

    public List<MeasuringData> getData() {
        return dataMapper.getData();
    }

    public MeasuringDataDto getDataWithValue() {
        return dataMapper.getDataWithValue();
    }

    public MeasuringDataDto getMeasuringData(Long id) {
        return dataMapper.getMeasuringData(id);
    }
}
