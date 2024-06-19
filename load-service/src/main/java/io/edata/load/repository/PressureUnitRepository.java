package io.gentjankolicaj.app.edata.load.repository;

import io.edata.commons.domain.PressureUnit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PressureUnitRepository extends CrudRepository<PressureUnit, String> {

  List<PressureUnit> findPressureUnitByUnitNameLike(String unitName);
}
