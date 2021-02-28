package am.hay.cc.controller;

import am.hay.cc.model.WindowCleaning;
import am.hay.cc.service.WindowCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/window-cleaning")
public class WindowCleaningController {

    private WindowCleaningService windowCleaningService;


    @Autowired
    public WindowCleaningController(final WindowCleaningService windowCleaningService) {
        this.windowCleaningService = windowCleaningService;
    }


    @GetMapping("")
    public ResponseEntity<List<WindowCleaning>> getAll() {
        return new ResponseEntity<>(windowCleaningService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WindowCleaning> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(windowCleaningService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<WindowCleaning> create(@RequestBody WindowCleaning windowCleaning) {
        return new ResponseEntity<>(windowCleaningService.save(windowCleaning), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final WindowCleaning windowCleaning) {
        return new ResponseEntity<>(windowCleaningService.updateById(windowCleaning, id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(windowCleaningService.deleteByID(id), HttpStatus.OK);
    }
}
