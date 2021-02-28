package am.hay.cc.controller;

import am.hay.cc.model.ServiceType;
import am.hay.cc.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-type")
public class ServiceTypeController {

    private ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeController(final ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping("")
    public ResponseEntity<List<ServiceType>> getAll() {
        return new ResponseEntity<>(serviceTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceType> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(serviceTypeService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceType> create(@RequestBody final ServiceType serviceType) {
        return new ResponseEntity<>(serviceTypeService.save(serviceType), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final ServiceType serviceType) {
        return new ResponseEntity<>(serviceTypeService.updateById(serviceType, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(serviceTypeService.deleteByID(id), HttpStatus.OK);
    }
}
