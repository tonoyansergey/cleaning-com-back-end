package am.hay.cc.controller;

import am.hay.cc.model.GeneralCleaning;
import am.hay.cc.service.GeneralCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general-cleaning")
public class GeneralCleaningController {

    private GeneralCleaningService generalCleaningService;

    @Autowired
    public GeneralCleaningController(final GeneralCleaningService generalCleaningService) {
        this.generalCleaningService = generalCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<GeneralCleaning>> getAll() {
        return new ResponseEntity<>(generalCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GeneralCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(generalCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GeneralCleaning> create(@RequestBody GeneralCleaning generalCleaning) {
        return new ResponseEntity<>(generalCleaningService.save(generalCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final GeneralCleaning generalCleaning) {
        return new ResponseEntity<>(generalCleaningService.updateById(generalCleaning, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(generalCleaningService.deleteByID(id), HttpStatus.OK);
    }
}