package kargo.hack8.beapp.controllers;

import kargo.hack8.beapp.models.entities.Shipment;
import kargo.hack8.beapp.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<Shipment> create(
            @RequestBody @Valid Shipment shipment){
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.create(shipment));
    }

    @GetMapping
    public Iterable<Shipment> findAll(){
        return shipmentService.findAll();
    }

    @GetMapping("/{id}")
    public Shipment findById(@PathVariable Long id){
        return shipmentService.findById(id);
    }
}
