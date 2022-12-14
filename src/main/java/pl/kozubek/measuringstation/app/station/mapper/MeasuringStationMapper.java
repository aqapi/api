package pl.kozubek.measuringstation.app.station.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

/**
 * Interfejs <code>MeasuringStationMapper</code> odpowiedzialna za udostępnienie metod, które pozwalają na komunikację z
 * bazą danych zarządzana przez MyBatis. Funkcja posiada 6 funkcji odpowiedzialne za dodawanie nowych danych do
 * bazy oraz sprawdzania czy takie dane istnieją w bazie. Interfejs rozszerza interfejs <code>ModelMapper</code>
 * aby zachować spójność wszystkich interfejsów w projekcie.
 */
@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    /**
     * Funkcja udostępniająca stację pomiarową według indetyfikatora.
     *
     * @param id identyfikator stacji jednoznacznie identyfikujący encję w bazie danych.
     * @return Stację pomiarowa
     */
    MeasuringStation getMeasuringStation(@Param("measuringStationId") Long id);

    /**
     * Funkcja udostępnia stację pomiarową według najbliższej lokalizacji geograficznej.
     *
     * @param gegrLat długość horyzontalna.
     * @param gegrLon długość wertykalna.
     * @return Stację jakości powietrza według najbliższej lokalizacji.
     */
    MeasuringDataDto getStationByNearestLocalization(@Param("gegrLat") Long gegrLat, @Param("gegrLon") Long gegrLon);

    /**
     * Funkcja udostępnia listę stacji pomiarowych.
     *
     * @return Lista stacji jakości powietrza.
     */
    List<MeasuringStation> getMeasuringStations();

    /**
     * Funkcja udostępnia listę stacji jakości powietrza wraz z informacjami.
     *
     * @return Lista stacji pomiarowych wraz z wszystkimi informacjami.
     */
    List<MeasuringStationDto> getMeasuringStationWithCityAndCommune();
}
