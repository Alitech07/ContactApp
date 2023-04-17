package spring.contactApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.contactApp.entity.SimCard;
import spring.contactApp.payload.ApiResponse;
import spring.contactApp.payload.SimCardDTO;
import spring.contactApp.service.SimCardSerivice;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/simcard")
public class SimCardController {
    @Autowired
    SimCardSerivice simCardSerivice;

    @GetMapping
    public HttpEntity<?> getSimCards(){
        List<SimCard> cards = simCardSerivice.getSimCardsService();
        return ResponseEntity.ok(cards);
    }

    @PostMapping("/add")
    public HttpEntity<?> addSimCard(@RequestBody SimCardDTO simCardDTO){
        ApiResponse apiResponse = simCardSerivice.addSimCardService(simCardDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteSimCard(@PathVariable UUID id){
        ApiResponse apiResponse = simCardSerivice.deleteSimCardService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
