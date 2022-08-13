package kargo.hack8.beapp.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kargo.hack8.beapp.models.DTO.TruckDTO;
import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.services.TruckService;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {
    
    @Autowired
    private TruckService truckService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Iterable<Truck> findAll(){
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public Truck findById(@PathVariable Long id){
        return truckService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Truck> create(@Valid @RequestBody TruckDTO truckDTO, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(new Truck());
        }
        Truck truck = modelMapper.map(truckDTO, Truck.class);
        return ResponseEntity.ok(truckService.create(truck));
    } 

    @PutMapping
    public Truck create (@RequestBody Truck truck){
        return truckService.create(truck);
    }
    
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        truckService.delete(id);
    }

}
