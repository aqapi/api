package pl.kozubek.measuringstation.app.station.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    MeasuringStation getMeasuringStation(@Param("measuringStationId") Long id);

    MeasuringDataDto getStationByNearestLocalization(@Param("gegrLat") Long gegrLat, @Param("gegrLon") Long gegrLon);

    List<MeasuringStation> getMeasuringStations();

    List<MeasuringStationDto> getMeasuringStationWithCityAndCommune();
}
