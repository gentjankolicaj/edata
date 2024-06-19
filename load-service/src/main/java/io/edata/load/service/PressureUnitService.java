package io.gentjankolicaj.app.edata.load.service;

import io.gentjankolicaj.app.edata.load.command.PressureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.PressureUnitDTO;
import java.util.List;

public interface PressureUnitService {

  List<PressureUnitDTO> getAllDTO();

  List<PressureUnitCmd> getAllCommand();

  PressureUnitDTO saveDTO(PressureUnitDTO pressureUnitDTO);

  PressureUnitCmd saveCommand(PressureUnitCmd pressureUnitCmd);

  PressureUnitDTO updateDTO(PressureUnitDTO pressureUnitDTO);

  PressureUnitCmd updateCommand(PressureUnitCmd pressureUnitCmd);

  PressureUnitDTO getByIdDTO(String id);

  PressureUnitCmd getByIdCommand(String id);

  void deleteDTO(PressureUnitDTO pressureUnitDTO);

  void deleteCommand(PressureUnitCmd pressureUnitCmd);

  List<PressureUnitDTO> getByUnitNameDTO(String unitName);

  List<PressureUnitCmd> getByUnitNameCommand(String unitName);
}
