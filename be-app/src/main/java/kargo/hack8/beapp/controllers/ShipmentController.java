package kargo.hack8.beapp.controllers;

import kargo.hack8.beapp.models.DTO.ResponseData;
import kargo.hack8.beapp.models.DTO.GetShipmentDTO;
import kargo.hack8.beapp.models.entities.Shipment;
import kargo.hack8.beapp.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shipment")
@CrossOrigin(origins = "http://localhost:3000")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ResponseData<GetShipmentDTO> create(
            @RequestBody Shipment shipment){
        return shipmentService.create(shipment);
    }

    @GetMapping
    public ResponseData<List<GetShipmentDTO>> findAll(){
        return shipmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseData<GetShipmentDTO> findById(@PathVariable Long id){
        return shipmentService.findById(id);
    }

    @PutMapping
    public ResponseData<GetShipmentDTO> update(@RequestBody @Valid Shipment shipment){
        return shipmentService.update(shipment);
    }
}
