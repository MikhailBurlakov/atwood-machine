package com.example.physics.sam.iisib24.web.ui;

import com.example.physics.sam.iisib24.model.AtwoodMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AtwoodController {

    private final AtwoodMachine atwoodMachine;

    public AtwoodController(AtwoodMachine atwoodMachine) {
        this.atwoodMachine = atwoodMachine;
    }

    @GetMapping({"/", "/atwood"})
    public String showAtwoodPage() {
        return "atwood";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public Map<String, Object> calculate(
            @RequestParam double height,
            @RequestParam double BigMass,
            @RequestParam double SmallMass,
            @RequestParam String planet) {
        
        atwoodMachine.setHeight(height);
        atwoodMachine.setMassM(BigMass);
        atwoodMachine.setMassm(SmallMass);
        atwoodMachine.setSelectedPlanet(planet);

        double fallTime = atwoodMachine.calculateFallTime();
        double gravity = atwoodMachine.getPlanetGravity();

        Map<String, Object> response = new HashMap<>();
        response.put("fallTime", String.format("%.3f", fallTime));
        response.put("gravity", String.format("%.2f", gravity));
        return response;
    }
} 