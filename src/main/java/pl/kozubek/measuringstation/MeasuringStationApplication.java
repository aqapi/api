package pl.kozubek.measuringstation;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import pl.kozubek.measuringstation.app.MeasuringStationComponent;
import pl.kozubek.measuringstation.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.measuringstation.app.data.service.MeasuringDataService;
import pl.kozubek.measuringstation.app.station.controller.MeasuringStationController;
import pl.kozubek.measuringstation.app.station.model.MeasuringStation;
import pl.kozubek.measuringstation.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.measuringstation.app.station.service.MeasuringStationService;
import pl.kozubek.measuringstation.mybatis.MyBatisComponent;
import pl.kozubek.measuringstation.mybatis.annotation.ModelMapper;
import pl.kozubek.measuringstation.webClient.MeasuringClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@RequiredArgsConstructor
@MapperScan(value = {"pl.kozubek.*.mapper", "pl.kozubek.**.mapper"}, markerInterface = ModelMapper.class)
@Import({
        MyBatisComponent.class,
        MeasuringStationComponent.class
})
public class MeasuringStationApplication {
    private final MeasuringStationService stationService;

    public static void main(String[] args) {
        SpringApplication.run(MeasuringStationApplication.class, args);
    }


    @Bean
    public Supplier<Boolean> callToGiosApi() {
        return stationService::callToGiosApi;
    }
}
