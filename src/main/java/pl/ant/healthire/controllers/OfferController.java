package pl.ant.healthire.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ant.healthire.payload.NonDetailedOffer;
import pl.ant.healthire.payload.OfferDto;
import pl.ant.healthire.services.OfferService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@CrossOrigin
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @PostMapping()
    public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto){
        return new ResponseEntity<>(offerService.createOffer(offerDto), HttpStatus.CREATED);
    }



    @GetMapping()
    public ResponseEntity<List<OfferDto>> getAllOffers(){
        return ResponseEntity.ok(offerService.getAllOffers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getOfferById(@PathVariable("id") Long offerId){
        return ResponseEntity.ok(offerService.getOfferById(offerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDto> updateOfferById(@RequestBody OfferDto offerDto,
                                                    @PathVariable("id") Long offerId){
        return new ResponseEntity<>(offerService.updateOfferById(offerDto, offerId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOfferById(@PathVariable("id") Long offerId){
        offerService.deleteOfferById(offerId);
        return new ResponseEntity<>("Offer deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<OfferDto>> searchOffersByTitle(
            @RequestParam(value="query", required = true) String query){
        return ResponseEntity.ok(offerService.searchOffersByTitle(query));
    }

    @GetMapping("/salary")
    public ResponseEntity<List<OfferDto>> searchOffersBySalaryRange(
            @RequestParam(value = "minSalary") Integer minSalary,
            @RequestParam(value = "maxSalary", required = false) Integer maxSalary){
        return ResponseEntity.ok(offerService.searchOffersBySalaryRange(minSalary, maxSalary));
    }

    @GetMapping("/city")
    public ResponseEntity<List<OfferDto>> getAllByCity(
            @RequestParam(value = "city", required = false) String city){
        return ResponseEntity.ok(offerService.getAllByCity(city));
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<OfferDto>> getAllByFilters(
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "minSalary", required = false) Integer minSalary,
            @RequestParam(value = "maxSalary", required = false) Integer maxSalary
    ){
        return ResponseEntity.ok(offerService.searchOffersByCityAndSalaryRange(city, minSalary, maxSalary));
    }


}
