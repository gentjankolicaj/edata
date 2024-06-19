package io.edata.load.repository.nasa.power;

import io.edata.commons.domain.nasa.power.PowerTemperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PowerTemperatureRepository extends CrudRepository<PowerTemperature, Long> {

}
