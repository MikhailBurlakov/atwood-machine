package com.example.physics.sam.iisib24.model;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

import static com.example.physics.sam.iisib24.Conts.*;

@Component
@Getter
@Setter
public class AtwoodMachine {
    private double height; // высота в метрах
    private double bigMass;  // масса M в кг
    private double smallMass;  // масса m в кг
    private String selectedPlanet; // выбранная планета

    public double getPlanetGravity() {
        return switch (selectedPlanet) {
            case "Mercury" -> G_MERCURY;
            case "Venus" -> G_VENUS;
            case "Moon" -> G_MOON;
            case "Mars" -> G_MARS;
            case "Ganymede" -> G_GANYMEDE;
            case "Callisto" -> G_CALLISTO;
            case "Titan" -> G_TITAN;
            case "Pluto" -> G_PLUTO;
            default -> G_EARTH;
        };
    }

    //расчёт времени падения
    public double calculateFallTime() {
        double g = getPlanetGravity();
        double a = calculateAcceleration(g);
        return Math.sqrt((2 * height) / a);
    }

    //расчёт ускорения
    private double calculateAcceleration(double g) {
        return (bigMass - smallMass) * g / (bigMass + smallMass);
    }

    // Методы для совместимости с контроллером
    public void setMassM(double BigMass) {
        this.bigMass = BigMass;
    }

    public void setMassm(double SmallMass) {
        this.smallMass = SmallMass;
    }
} 