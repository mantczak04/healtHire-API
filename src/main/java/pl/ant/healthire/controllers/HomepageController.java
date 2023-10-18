package pl.ant.healthire.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ant.healthire.payload.NonDetailedOffer;
import pl.ant.healthire.payload.OfferDto;
import pl.ant.healthire.services.OfferService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/homepage")
@CrossOrigin
public class HomepageController {

    private final OfferService offerService;

    public HomepageController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<List<NonDetailedOffer>> getAllNonDetailedOffers(){
        return ResponseEntity.ok(offerService.getAllNonDetailedOffers());
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<NonDetailedOffer>> getAllByCity(
            @RequestParam(value = "city", required = false) String city){
        return ResponseEntity.ok(offerService.getAllNonDetailedOffersByCity(city));
    }
}
