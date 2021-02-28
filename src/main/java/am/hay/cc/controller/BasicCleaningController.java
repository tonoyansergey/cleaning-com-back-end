package am.hay.cc.controller;

import am.hay.cc.model.BasicCleaning;
import am.hay.cc.service.BasicCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basic-cleaning")
public class BasicCleaningController {

    private BasicCleaningService basicCleaningService;

    @Autowired
    public BasicCleaningController(final BasicCleaningService basicCleaningService) {
        this.basicCleaningService = basicCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<BasicCleaning>> getAll() {
        return new ResponseEntity<>(basicCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BasicCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(basicCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BasicCleaning> create(@RequestBody BasicCleaning basicCleaning) {
        return new ResponseEntity<>(basicCleaningService.save(basicCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final BasicCleaning basicCleaning) {
        return new ResponseEntity<>(basicCleaningService.updateById(basicCleaning, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(basicCleaningService.deleteByID(id), HttpStatus.OK);
    }

}