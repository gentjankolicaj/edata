package io.gentjankolicaj.app.edata.load.mapper;

import io.edata.commons.domain.Country;
import io.gentjankolicaj.app.edata.load.command.CountryCmd;
import io.gentjankolicaj.app.edata.load.dto.CountryDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

  CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

  @Mapping(source = "countryName", target = "countryName")
  @Mapping(source = "isoCodes", target = "isoCodes")
  @Mapping(source = "phonePrefix", target = "phonePrefix")
  CountryDTO sourceToDto(Country source);

  @Mapping(source = "countryName", target = "countryName")
  @Mapping(source = "isoCodes", target = "isoCodes")
  @Mapping(source = "phonePrefix", target = "phonePrefix")
  CountryCmd sourceToCommand(Country source);

  @Mapping(source = "countryName", target = "countryName")
  @Mapping(source = "isoCodes", target = "isoCodes")
  @Mapping(source = "phonePrefix", target = "phonePrefix")
  Country dtoToSource(CountryDTO dto);

  @Mapping(source = "countryName", target = "countryName")
  @Mapping(source = "isoCodes", target = "isoCodes")
  @Mapping(source = "phonePrefix", target = "phonePrefix")
  Country commandToSource(CountryCmd command);

  List<CountryDTO> sourceToDto(List<Country> source);

  List<CountryCmd> sourceToCommand(List<Country> source);
}
