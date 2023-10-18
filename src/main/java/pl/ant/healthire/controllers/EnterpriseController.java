package pl.ant.healthire.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ant.healthire.payload.EnterpriseDto;
import pl.ant.healthire.services.EnterpriseService;

import java.util.List;

@RequestMapping("/api/v1/enterprises")
@RestController
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping
    public ResponseEntity<EnterpriseDto> createEnterprise(@RequestBody EnterpriseDto enterpriseDto){
        return new ResponseEntity<>(enterpriseService.createEnterprise(enterpriseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnterpriseDto>> getAllEnterprises(){
        return ResponseEntity.ok(enterpriseService.getAllEnterprises());
    }
}
