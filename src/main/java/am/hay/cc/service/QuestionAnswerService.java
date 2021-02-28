package am.hay.cc.service;

import am.hay.cc.model.QuestionAnswer;
import java.util.List;

public interface QuestionAnswerService {

    List<QuestionAnswer> findAll();

    QuestionAnswer save(final QuestionAnswer questionAnswer);

    QuestionAnswer updateById(final QuestionAnswer questionAnswer, final String id);

    boolean deleteByID(final String id);

    QuestionAnswer findById(final String id);
}
