package io.edata.load.service.nasa;

import io.edata.load.command.nasa.power.PowerPressureCmd;
import io.edata.load.dto.nasa.power.PowerPressureDTO;
import java.util.List;

public interface PowerPressureService {

  List<PowerPressureDTO> getAllDTO();

  List<PowerPressureCmd> getAllCommand();

  PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO);

  PowerPressureCmd saveCommand(PowerPressureCmd powerPressureCmd);

  PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO);

  PowerPressureCmd updateCommand(PowerPressureCmd powerPressureCmd);


  PowerPressureDTO getByIdDTO(Long id);

  PowerPressureCmd getByIdCommand(Long id);

  void deleteDTO(PowerPressureDTO powerPressureDTO);

  void deleteCommand(PowerPressureCmd powerPressureCmd);

  List<PowerPressureDTO> retrieveDTO(Long userId, String identifier, String dataParameters,
      String startDate, String endDate,
      String userCommunity, String tempAverage,
      String outputFormat, String lat, String lon, String bbox);

  List<PowerPressureCmd> retrieveCommand(Long userId, String identifier, String dataParameters,
      String startDate, String endDate,
      String userCommunity, String tempAverage,
      String outputFormat, String lat, String lon, String bbox);


}
