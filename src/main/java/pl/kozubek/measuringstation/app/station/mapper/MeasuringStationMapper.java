package pl.kozubek.measuringstation.app.station.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.measuringstation.app.station.model.MeasuringCity;
import pl.kozubek.measuringstation.app.station.model.MeasuringCityCommune;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    MeasuringStation getMeasuringStation(@Param("measuringStationId") Long id);

    MeasuringStationDto getStationByNearestLocalization(@Param("gegrLat") Long gegrLat, @Param("gegrLon") Long gegrLon);

    List<MeasuringStation> getMeasuringStations();

    List<MeasuringStationDto> getMeasuringStationWithCityAndCommune();

    void addMeasuringCommune(@Param("measuringCommune") MeasuringCityCommune commune);

    void addMeasuringCity(@Param("measuringCity") MeasuringCity city);

    void addMeasuringStation(@Param("measuringStation") MeasuringStation station);

    boolean existStationById(@Param("id") Long id);

    boolean existCityById(@Param("id") Long id);

    boolean existCommuneByCommuneNameAndDistrictNameAndProvinceName(@Param("communeName") String communeName,
                                                                    @Param("districtName") String districtName,
                                                                    @Param("provinceName") String provinceName);
}
