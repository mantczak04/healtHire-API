package pl.ant.healthire.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ant.healthire.payload.OfficeDto;
import pl.ant.healthire.services.OfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping
    public ResponseEntity<OfficeDto> createOffice(@RequestBody OfficeDto officeDto){
        return new ResponseEntity<>(officeService.createOffice(officeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OfficeDto>> getAllOffices(){
        return ResponseEntity.ok(officeService.getAllOffices());
    }
}
