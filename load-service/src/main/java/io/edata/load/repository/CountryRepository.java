package io.gentjankolicaj.app.edata.load.repository;

import io.edata.commons.domain.Country;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

  List<Country> findCountriesByCountryNameLike(String countryName);

  List<Country> findCountriesByPhonePrefixLike(String phonePrefix);

  List<Country> findCountriesByIsoCodesLike(String isoCodes);
}
