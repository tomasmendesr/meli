package meli.tmr.sistemasolar;

import meli.tmr.sistemasolar.models.Betasoide;
import meli.tmr.sistemasolar.models.Ferengi;
import meli.tmr.sistemasolar.models.SolarSystem;
import meli.tmr.sistemasolar.models.Vulcano;
import meli.tmr.sistemasolar.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class AppInitializator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppInitializator.class);
    @Autowired
    private WeatherService weatherService;

    @PostConstruct
    private void init(){
        LOGGER.info("App initialization");
        LOGGER.info("Ejecutando prediccion del clima para los proximos 10 años");
        SolarSystem solarSystem = new SolarSystem(Arrays.asList(new Vulcano(), new Betasoide(), new Ferengi()));
        LOGGER.info("Sistema solar creado con los planetas: " + solarSystem.getPlanets());
        weatherService.getWeatherReport(solarSystem,10);
        LOGGER.info("Predicción del clima terminada");
    }

}