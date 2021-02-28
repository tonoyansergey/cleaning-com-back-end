package am.hay.cc.controller;

import am.hay.cc.model.HomeCleaning;
import am.hay.cc.service.HomeCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-cleaning")
public class HomeCleaningController {
    private final HomeCleaningService homeCleaningService;

    @Autowired
    public HomeCleaningController(final HomeCleaningService homeCleaningService) {
        this.homeCleaningService = homeCleaningService;
    }

    @GetMapping("")
    public ResponseEntity<List<HomeCleaning>> getAll() {
        return new ResponseEntity<>(homeCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HomeCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(homeCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HomeCleaning> create(@RequestBody final HomeCleaning homeCleaning) {
        return new ResponseEntity<>(homeCleaningService.save(homeCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final HomeCleaning homeCleaning) {
        return new ResponseEntity<>(homeCleaningService.updateById(homeCleaning, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(homeCleaningService.deleteByID(id), HttpStatus.OK);
    }

}
