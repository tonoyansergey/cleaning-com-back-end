package am.hay.cc.controller;

import am.hay.cc.model.QuestionAnswer;
import am.hay.cc.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-answer")
public class QuestionAnswerController {

    private final QuestionAnswerService questionAnswerService;

    @Autowired
    public QuestionAnswerController(final QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @GetMapping("")
    public ResponseEntity<List<QuestionAnswer>> getAll() {
        return new ResponseEntity<>(questionAnswerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionAnswer> getrById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(questionAnswerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionAnswer> create(@RequestBody final QuestionAnswer questionAnswerBean) {
        return new ResponseEntity<>(questionAnswerService.save(questionAnswerBean), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") final String id, @RequestBody final QuestionAnswer questionAnswer) {
        return new ResponseEntity<>(questionAnswerService.updateById(questionAnswer, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<>(questionAnswerService.deleteByID(id), HttpStatus.OK);
    }
}
