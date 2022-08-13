package kargo.hack8.beapp.controllers;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kargo.hack8.beapp.models.entities.Driver;
import kargo.hack8.beapp.services.DriverService;
@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "http://localhost:3000")
public class DriverController {
    @Autowired
    private DriverService driverService;

    long now = System.currentTimeMillis();
    Date date = new Date(now);

    @PostMapping
    public ResponseEntity<Driver> create(@RequestBody @Valid Driver driver){
        driver.setCreatedAt(date);
        return ResponseEntity.status(HttpStatus.OK).body(driverService.create(driver));
    }

    @GetMapping
    public @ResponseBody Iterable<Driver> findAll(){
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public Driver findById(@PathVariable Long id){
        return driverService.findById(id);
    }

    @PutMapping
    public Driver update(@RequestBody Driver driver){
        return driverService.create(driver);
    }
}
