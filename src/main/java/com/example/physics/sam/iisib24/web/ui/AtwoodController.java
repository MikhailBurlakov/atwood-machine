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
            @RequestParam double massM,
            @RequestParam double massm,
            @RequestParam String planet) {
        
        atwoodMachine.setHeight(height);
        atwoodMachine.setMassM(massM);
        atwoodMachine.setMassm(massm);
        atwoodMachine.setSelectedPlanet(planet);

        double fallTime = atwoodMachine.calculateFallTime();

        Map<String, Object> response = new HashMap<>();
        response.put("fallTime", String.format("%.3f", fallTime));
        return response;
    }
} 