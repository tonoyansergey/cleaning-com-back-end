package am.hay.cc.controller;

import am.hay.cc.model.OfficeCleaning;
import am.hay.cc.service.OfficeCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office-cleaning")
public class OfficeCleaningController {

    private OfficeCleaningService officeCleaningService;


    @Autowired
    public OfficeCleaningController(final OfficeCleaningService officeCleaningService) {
        this.officeCleaningService = officeCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<OfficeCleaning>> getAll() {
        return new ResponseEntity<>(officeCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OfficeCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(officeCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OfficeCleaning> create(@RequestBody OfficeCleaning officeCleaning) {

        return new ResponseEntity<>(officeCleaningService.save(officeCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final OfficeCleaning officeCleaning) {
        return new ResponseEntity<>(officeCleaningService.updateById(officeCleaning, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(officeCleaningService.deleteByID(id), HttpStatus.OK);
    }
}