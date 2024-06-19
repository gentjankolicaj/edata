package io.gentjankolicaj.app.edata.load.service;

import io.gentjankolicaj.app.edata.load.command.TemperatureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.TemperatureUnitDTO;
import java.util.List;

public interface TemperatureUnitService {

  List<TemperatureUnitDTO> getAllDTO();

  List<TemperatureUnitCmd> getAllCommand();

  TemperatureUnitDTO saveDTO(TemperatureUnitDTO temperatureUnitDTO);

  TemperatureUnitCmd saveCommand(TemperatureUnitCmd temperatureUnitCmd);

  TemperatureUnitDTO updateDTO(TemperatureUnitDTO temperatureUnitDTO);

  TemperatureUnitCmd updateCommand(TemperatureUnitCmd temperatureUnitCmd);

  TemperatureUnitDTO getByIdDTO(String id);

  TemperatureUnitCmd getByIdCommand(String id);

  void deleteDTO(TemperatureUnitDTO temperatureUnitDTO);

  void deleteCommand(TemperatureUnitCmd temperatureUnitCmd);

  List<TemperatureUnitDTO> getByUnitNameDTO(String unitName);

  List<TemperatureUnitCmd> getByUnitNameCommand(String unitName);
}
