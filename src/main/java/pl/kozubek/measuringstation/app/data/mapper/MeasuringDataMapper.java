package pl.kozubek.measuringstation.app.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.measuringstation.app.data.model.MeasuringData;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

import java.util.List;

/**
 * Interfejs <code>MeasuringDataMapper</code> odpowiedzialna za udostępnienie metod, które pozwalają na komunikację z
 * bazą danych zarządzana przez MyBatis. Funkcja posiada 3 funkcje odpowiedzialne tylko za dodawanie nowych danych do
 * bazy. Interfejs rozszerza interfejs <code>ModelMapper</code> aby zachować spójność wszystkich interfejsów w projekcie.
 */
@Mapper
public interface MeasuringDataMapper extends ModelMapper {

    /**
     * Funkcja udostępnia listę wszystkich dostępnych danych z wszystkich stacji pogodowych w kraju.
     *
     * @return Lista danych jakości powietrza.
     */
    List<MeasuringData> getData();

    /**
     * Funkcja udostępnia dane bez identyfikatora.
     *
     * @return Dane jakości powietrza bez identyfikatora.
     */
    MeasuringDataDto getDataWithValue();

    /**
     * Funkcja udostępnia dane z konkretnej stacji jakości powietrza poprzez podanie identyfikatora stacji.
     *
     * @param id identyfikator stacji jednoznacznie identyfikujący encję.
     * @return Dane jakości powietrza z stacji jakości powietrza.
     */
    MeasuringDataDto getMeasuringData(@Param("dataId") Long id);
}