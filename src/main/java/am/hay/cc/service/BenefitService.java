package am.hay.cc.service;

import am.hay.cc.model.Benefit;
import java.util.List;

public interface BenefitService {

    List<Benefit> findAll();

    Benefit save(final Benefit benefit);

    Benefit updateById(final Benefit benefit, final String id);

    boolean deleteByID(final String id);

    Benefit findById(final String id);
}
