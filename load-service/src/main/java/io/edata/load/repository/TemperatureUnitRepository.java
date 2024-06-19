package io.edata.load.repository;

import io.edata.commons.domain.TemperatureUnit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureUnitRepository extends CrudRepository<TemperatureUnit, String> {

  List<TemperatureUnit> findTemperatureUnitByUnitNameLike(String unitName);
}
