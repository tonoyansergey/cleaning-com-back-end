package am.hay.cc.controller;

import am.hay.cc.model.AfterRepairCleaning;
import am.hay.cc.service.AfterRepairCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/after-repair-cleaning")
public class AfterRepairCleaningController {

    private AfterRepairCleaningService afterRepairCleaningService;

    @Autowired
    public AfterRepairCleaningController(final AfterRepairCleaningService afterRepairCleaningService) {
        this.afterRepairCleaningService = afterRepairCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<AfterRepairCleaning>> getAll() {
        return new ResponseEntity<>(afterRepairCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AfterRepairCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(afterRepairCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AfterRepairCleaning> create(@RequestBody AfterRepairCleaning afterRepairCleaning) {
        return new ResponseEntity<>(afterRepairCleaningService.save(afterRepairCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final AfterRepairCleaning afterRepairCleaning) {
        return new ResponseEntity<>(afterRepairCleaningService.updateById(afterRepairCleaning, id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(afterRepairCleaningService.deleteByID(id), HttpStatus.OK);
    }
}
