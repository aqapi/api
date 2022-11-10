package pl.kozubek.measuringstation.app.station.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    MeasuringStation getMeasuringStation(@Param("measuringStationId") Long id);

//    @Select("select * from MEASURING_STATION")
    List<MeasuringStation> getMeasuringStations();

//    @Insert("INSERT INTO MEASURING_STATION (id, station_name, gegr_lat, gegr_lon, city, address_street)\n" +
//            "VALUES (#{measuringStation.id}, #{measuringStation.stationName}, #{measuringStation.gegrLat},\n" +
//            "#{measuringStation.gegrLon}, #{measuringStation.city}, #{measuringStation.addressStreet})")
    void addMeasuringStation(@Param("measuringStation") MeasuringStation station);

}
