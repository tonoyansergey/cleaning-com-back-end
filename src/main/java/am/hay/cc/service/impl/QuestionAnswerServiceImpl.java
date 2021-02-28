package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.QuestionAnswer;
import am.hay.cc.repository.QuestionAnswerRepository;
import am.hay.cc.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private final QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public QuestionAnswerServiceImpl(final QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    @Override
    public List<QuestionAnswer> findAll() {
        return Optional.of(questionAnswerRepository.findAll()).orElseThrow(() -> new RecordNotFoundException("Q&A data not found"));
    }

    @Override
    public QuestionAnswer save(final QuestionAnswer questionAnswer) {
        return Optional.of(questionAnswerRepository.save(questionAnswer)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public QuestionAnswer updateById(final QuestionAnswer questionAnswer, final String id) {
        return questionAnswerRepository.findById(id).
                map(existingUser -> {
                    questionAnswer.setId(existingUser.getId());
                    existingUser = questionAnswer;
                    return questionAnswerRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            questionAnswerRepository.deleteById(id);
            return true;
        } catch (
                Exception e) {
            return false;
        }
    }

    @Override
    public QuestionAnswer findById(final String id) {
        return questionAnswerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Question record not found"));
    }
}
