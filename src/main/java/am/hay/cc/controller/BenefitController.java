package am.hay.cc.controller;

import am.hay.cc.model.Benefit;
import am.hay.cc.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefit")
public class BenefitController {
    private final BenefitService benefitService;

    @Autowired
    public BenefitController(final BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("")
    public ResponseEntity<List<Benefit>> getAll() {
        return new ResponseEntity<>(benefitService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Benefit> getById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(benefitService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Benefit> create(@RequestBody final Benefit benefit) {
        return new ResponseEntity<>(benefitService.save(benefit), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final Benefit benefit) {
        return new ResponseEntity<>(benefitService.updateById(benefit, id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(benefitService.deleteByID(id), HttpStatus.OK);
    }

}
