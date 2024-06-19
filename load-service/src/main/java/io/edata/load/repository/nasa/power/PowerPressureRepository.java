package io.edata.load.repository.nasa.power;

import io.edata.commons.domain.nasa.power.PowerPressure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerPressureRepository extends CrudRepository<PowerPressure, Long> {

}
