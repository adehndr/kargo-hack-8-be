package kargo.hack8.beapp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kargo.hack8.beapp.models.DTO.ResponseData;
import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.repository.TruckRepository;

@Service
@Transactional
public class TruckService {
    
    @Autowired
    private TruckRepository truckRepository;

    public ResponseData<Iterable<Truck>> findAll() {
        ResponseData<Iterable<Truck>> responseData = new ResponseData<Iterable<Truck>>();
        responseData.setMessages("success find all trucs");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(truckRepository.findAll());
        return responseData;
    }

    public ResponseData<Truck> findById(Long id){
        ResponseData<Truck> responseData = new ResponseData<Truck>();
        Optional<Truck> truckFounded = truckRepository.findById(id);
        if (!truckFounded.isPresent()) {
            responseData.setMessages("Cannot find truck with id " + id);
            responseData.setStatus(HttpStatus.BAD_REQUEST);
            responseData.setPayload(new Truck());
            return responseData;
        }
        responseData.setMessages("Success to find the truck");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(truckFounded.get());
        return responseData;
    }

    public ResponseData<Truck> create(Truck truck){
        ResponseData<Truck> responseData = new ResponseData<Truck>();
        responseData.setMessages("Success create a new truck");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(truckRepository.save(truck));
        return responseData;
    }

    public ResponseData<Void> delete(Long id){
        truckRepository.deleteById(id);
        ResponseData<Void> responseData = new ResponseData<Void>();
        responseData.setMessages("Success delete the truck");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(null);
        return responseData;
    }

    public ResponseData<List<Truck>> findTruckWhereActive(){
        ResponseData<List<Truck>> responseData = new ResponseData<List<Truck>>();
        responseData.setMessages("success find all trucs");
        responseData.setStatus(HttpStatus.OK);
        responseData.setPayload(truckRepository.findByStatus(true));
        return responseData;
    }
}
