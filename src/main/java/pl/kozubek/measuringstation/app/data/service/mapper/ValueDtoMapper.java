package pl.kozubek.measuringstation.app.data.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.measuringstation.app.data.model.MeasuringValue;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringValueDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ValueDtoMapper {

    public MeasuringValue to(MeasuringValueDto valueDto) {
        return MeasuringValue.builder()
                .date(valueDto.getDate())
                .value(valueDto.getValue())
                .build();
    }

    public List<MeasuringValue> to(List<MeasuringValueDto> valuesDto) {
        return valuesDto.stream()
                .map(this::to)
                .toList();
    }

    public MeasuringValueDto to(MeasuringValue value) {
        return MeasuringValueDto.builder()
                .date(value.getDate())
                .value(value.getValue())
                .build();
    }
}
