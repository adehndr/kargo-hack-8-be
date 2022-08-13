package kargo.hack8.beapp.controllers;


import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kargo.hack8.beapp.models.entities.Driver;
import kargo.hack8.beapp.services.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<Driver> create(
            @RequestBody @Valid Driver driver){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.create(driver));
    }

    @GetMapping
    public @ResponseBody Iterable<Driver> findAll(){
        return driverService.findAll();
    }
}