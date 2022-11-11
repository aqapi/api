package pl.kozubek.measuringstation.app.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

@Mapper
public interface MeasuringDataMapper extends ModelMapper {
    List<MeasuringData> getData();

    MeasuringDataDto getDataWithValue();
}
