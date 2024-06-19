package io.gentjankolicaj.app.edata.load.service;

import io.gentjankolicaj.app.edata.load.command.CountryCmd;
import io.gentjankolicaj.app.edata.load.dto.CountryDTO;
import java.util.List;

public interface CountryService {

  List<CountryDTO> getAllDTO();

  List<CountryCmd> getAllCommand();

  CountryDTO saveDTO(CountryDTO countryDTO);

  CountryCmd saveCommand(CountryCmd countryCmd);

  CountryDTO updateDTO(CountryDTO countryDTO);

  CountryCmd updateCommand(CountryCmd countryCmd);


  CountryDTO getByIdDTO(String id);

  CountryCmd getByIdCommand(String id);

  void deleteDTO(CountryDTO countryDTO);

  void deleteCommand(CountryCmd countryCmd);

  List<CountryDTO> getByCountryNameDTO(String countryName);

  List<CountryCmd> getByCountryNameCommand(String countryName);

  List<CountryDTO> getByPhonePrefixDTO(String phonePrefix);

  List<CountryCmd> getByPhonePrefixCommand(String phonePrefix);

  List<CountryDTO> getByIsoCodeDTO(String isoCodes);

  List<CountryCmd> getByIsoCodeCommand(String isoCodes);
}
