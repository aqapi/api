package pl.kozubek.measuringstation;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.kozubek.measuringstation.app.MeasuringStationComponent;
import pl.kozubek.measuringstation.mybatis.MyBatisComponent;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;

/**
 * Klasa <code>WriterLambdaApplication</code> główna odpowiedzialna za konfigurację oraz uruchomienie serwera spring boot.
 * Klasa jest również odpowiedzialna za połączenie wszystkich komponentów. Obiekt powinien przy uruchomieniu serwera
 * uruchomić metodę <code>call</code>.
 */
@SpringBootApplication
@RequiredArgsConstructor
@MapperScan(value = {"pl.kozubek.*.mapper", "pl.kozubek.**.mapper"}, markerInterface = ModelMapper.class)
@Import({
        MyBatisComponent.class,
        MeasuringStationComponent.class
})
public class MeasuringStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeasuringStationApplication.class, args);
    }

}