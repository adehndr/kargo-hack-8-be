package kargo.hack8.beapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kargo.hack8.beapp.models.DTO.ResponseData;
import kargo.hack8.beapp.models.DTO.TruckDTO;
import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.services.TruckService;

@RestController
@RequestMapping("/api/trucks")
@CrossOrigin(origins = "http://localhost:3000")
public class TruckController {
    
    @Autowired
    private TruckService truckService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseData<Iterable<Truck>> findAll(){
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseData<Truck> findById(@PathVariable Long id){
        return truckService.findById(id);
    }

    @PostMapping()
    public ResponseData<Truck> create(@Valid @RequestBody TruckDTO truckDTO, Errors errors){
        return truckService.create(modelMapper.map(truckDTO, Truck.class));
    } 

    @PutMapping
    public ResponseData<Truck> create (@RequestBody Truck truck){
        return truckService.create(truck);
    }
    
    @DeleteMapping("/{id}")
    public ResponseData<Void> delete (@PathVariable Long id){
        return truckService.delete(id);
    }

    @GetMapping("/active")
    public ResponseData<List<Truck>> findTruckWhereActive(){
        return truckService.findTruckWhereActive();
    }

}
