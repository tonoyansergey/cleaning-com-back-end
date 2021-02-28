package am.hay.cc.controller;

import am.hay.cc.model.Feature;
import am.hay.cc.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature")
public class FeatureController {

    private final FeatureService featureService;

    @Autowired
    public FeatureController(final FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("")
    public ResponseEntity<List<Feature>> getAll() {
        return new ResponseEntity<>(featureService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feature> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(featureService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Feature> create(@RequestBody final Feature feature) {
        return new ResponseEntity<>(featureService.save(feature), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final Feature feature) {
        return new ResponseEntity<>(featureService.updateById(feature, id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(featureService.deleteByID(id), HttpStatus.OK);
    }
}
