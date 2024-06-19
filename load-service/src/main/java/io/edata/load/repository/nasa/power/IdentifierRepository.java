package io.gentjankolicaj.app.edata.load.repository.nasa.power;

import io.edata.commons.domain.nasa.power.Identifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends CrudRepository<Identifier, String> {

}
