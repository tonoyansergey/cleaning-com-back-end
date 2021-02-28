package am.hay.cc.controller;

import am.hay.cc.model.MaintainCleaning;
import am.hay.cc.service.MaintainCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintain-cleaning")
public class MaintainCleaningController {

    private MaintainCleaningService maintainCleaningService;

    @Autowired
    public MaintainCleaningController(final MaintainCleaningService maintainCleaningService) {
        this.maintainCleaningService = maintainCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<MaintainCleaning>> getAll() {
        return new ResponseEntity<>(maintainCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MaintainCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(maintainCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MaintainCleaning> create(@RequestBody MaintainCleaning maintainCleaning) {
        return new ResponseEntity<>(maintainCleaningService.save(maintainCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final MaintainCleaning maintainCleaning) {
        return new ResponseEntity<>(maintainCleaningService.updateById(maintainCleaning, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(maintainCleaningService.deleteByID(id), HttpStatus.OK);
    }
}