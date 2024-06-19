package io.gentjankolicaj.app.edata.load.service;

import io.edata.commons.domain.Country;
import io.gentjankolicaj.app.edata.load.command.CountryCmd;
import io.gentjankolicaj.app.edata.load.dto.CountryDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.CountryNotFoundException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.mapper.CountryMapper;
import io.gentjankolicaj.app.edata.load.repository.CountryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

  private final CountryRepository countryRepository;
  private final CountryMapper countryMapper;

  @Autowired
  public CountryServiceImpl(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
    this.countryMapper = CountryMapper.INSTANCE;
  }

  @Override
  public List<CountryDTO> getAllDTO() {
    List<CountryDTO> list = new ArrayList<>();
    Iterable<Country> iterable = countryRepository.findAll();
    for (Country temp : iterable) {
      list.add(countryMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<CountryCmd> getAllCommand() {
    List<CountryCmd> list = new ArrayList<>();
    Iterable<Country> iterable = countryRepository.findAll();
    for (Country temp : iterable) {
      list.add(countryMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public CountryDTO saveDTO(CountryDTO countryDTO) {
    if (countryDTO == null) {
      throw new NullReferenceException("Country not saved.Reference passed is null !!!");
    } else {
      Country savedCountry = countryRepository.save(countryMapper.dtoToSource(countryDTO));
      return countryMapper.sourceToDto(savedCountry);
    }
  }

  @Override
  public CountryCmd saveCommand(CountryCmd countryCmd) {
    if (countryCmd == null) {
      throw new NullReferenceException("Country not saved.Reference passed is null !!!");
    } else {
      Country savedCountry = countryRepository.save(countryMapper.commandToSource(countryCmd));
      return countryMapper.sourceToCommand(savedCountry);
    }
  }

  @Override
  public CountryDTO updateDTO(CountryDTO countryDTO) {
    if (countryDTO == null) {
      throw new NullReferenceException("Country not found.Reference passed is null !!!");
    } else {
      Country newCountry = countryMapper.dtoToSource(countryDTO);
      Optional<Country> optional = countryRepository.findById(newCountry.getCountryName());
      if (!optional.isPresent()) {
        CountryDTO savedCountry = countryMapper.sourceToDto(countryRepository.save(newCountry));
        return savedCountry;
      } else {
        Country actual = optional.get();
        actual.setIsoCodes(newCountry.getIsoCodes());
        actual.setPhonePrefix(newCountry.getPhonePrefix());
        return countryMapper.sourceToDto(actual);
      }
    }
  }

  @Override
  public CountryCmd updateCommand(CountryCmd countryCmd) {
    if (countryCmd == null) {
      throw new NullReferenceException("Country not found.Reference passed is null !!!");
    } else {
      Country newCountry = countryMapper.commandToSource(countryCmd);
      Optional<Country> optional = countryRepository.findById(newCountry.getCountryName());
      if (!optional.isPresent()) {
        CountryCmd savedCountry = countryMapper.sourceToCommand(countryRepository.save(newCountry));
        return savedCountry;
      } else {
        Country actual = optional.get();
        actual.setIsoCodes(newCountry.getIsoCodes());
        actual.setPhonePrefix(newCountry.getPhonePrefix());
        return countryMapper.sourceToCommand(actual);
      }
    }
  }

  @Override
  public CountryDTO getByIdDTO(String id) {
    if (id == null) {
      throw new NullIdException("Country id is null.");
    } else {
      Optional<Country> optional = countryRepository.findById(id);
      if (!optional.isPresent()) {
        throw new CountryNotFoundException("Country with id " + id + " not found.");
      } else {
        return countryMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public CountryCmd getByIdCommand(String id) {
    if (id == null) {
      throw new NullIdException("Country id is null.");
    } else {
      Optional<Country> optional = countryRepository.findById(id);
      if (!optional.isPresent()) {
        throw new CountryNotFoundException("Country with id " + id + " not found.");
      } else {
        return countryMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(CountryDTO countryDTO) {
    if (countryDTO == null) {
      throw new NullReferenceException("Country not deleted.Reference passed is null !!!");
    } else {
      Country country = countryMapper.dtoToSource(countryDTO);
      countryRepository.delete(country);
    }

  }

  @Override
  public void deleteCommand(CountryCmd countryCmd) {
    if (countryCmd == null) {
      throw new NullReferenceException("Country not deleted.Reference passed is null !!!");
    } else {
      Country country = countryMapper.commandToSource(countryCmd);
      countryRepository.delete(country);
    }
  }

  @Override
  public List<CountryDTO> getByCountryNameDTO(String countryName) {
    if (countryName == null) {
      throw new NullReferenceException(
          "Countries not found by countryName.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByCountryNameLike(countryName);
      return countryMapper.sourceToDto(tempList);
    }
  }

  @Override
  public List<CountryCmd> getByCountryNameCommand(String countryName) {
    if (countryName == null) {
      throw new NullReferenceException(
          "Countries not found by countryName.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByCountryNameLike(countryName);
      return countryMapper.sourceToCommand(tempList);
    }
  }

  @Override
  public List<CountryDTO> getByPhonePrefixDTO(String phonePrefix) {
    if (phonePrefix == null) {
      throw new NullReferenceException(
          "Countries not found by phonePrefix.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
      return countryMapper.sourceToDto(tempList);
    }

  }

  @Override
  public List<CountryCmd> getByPhonePrefixCommand(String phonePrefix) {
    if (phonePrefix == null) {
      throw new NullReferenceException(
          "Countries not found by phonePrefix.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByPhonePrefixLike(phonePrefix);
      return countryMapper.sourceToCommand(tempList);
    }
  }

  @Override
  public List<CountryDTO> getByIsoCodeDTO(String isoCodes) {
    if (isoCodes == null) {
      throw new NullReferenceException(
          "Countries not found by isoCodes.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByIsoCodesLike(isoCodes);
      return countryMapper.sourceToDto(tempList);
    }
  }

  @Override
  public List<CountryCmd> getByIsoCodeCommand(String isoCodes) {
    if (isoCodes == null) {
      throw new NullReferenceException(
          "Countries not found by isoCodes.Reference passed is null !!!");
    } else {
      List<Country> tempList = countryRepository.findCountriesByIsoCodesLike(isoCodes);
      return countryMapper.sourceToCommand(tempList);
    }
  }


}
