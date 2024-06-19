package io.gentjankolicaj.app.edata.load.service.nasa;

import io.gentjankolicaj.app.edata.load.command.nasa.power.PowerTemperatureCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerTemperatureDTO;
import java.util.List;

public interface PowerTemperatureService {

  List<PowerTemperatureDTO> getAllDTO();

  List<PowerTemperatureCmd> getAllCommand();

  PowerTemperatureDTO saveDTO(PowerTemperatureDTO powerTemperatureDTO);

  PowerTemperatureCmd saveCommand(PowerTemperatureCmd powerTemperatureCmd);

  PowerTemperatureDTO updateDTO(PowerTemperatureDTO powerTemperatureDTO);

  PowerTemperatureCmd updateCommand(PowerTemperatureCmd powerTemperatureCmd);

  PowerTemperatureDTO getByIdDTO(Long id);

  PowerTemperatureCmd getByIdCommand(Long id);

  void deleteDTO(PowerTemperatureDTO powerTemperatureDTO);

  void deleteCommand(PowerTemperatureCmd powerTemperatureCmd);

  List<PowerTemperatureDTO> retrieveDTO(Long userId, String identifier, String dataParameters,
      String startDate, String endDate,
      String userCommunity, String tempAverage,
      String outputFormat, String lat, String lon, String bbox);

  List<PowerTemperatureCmd> retrieveCommand(Long userId, String identifier, String dataParameters,
      String startDate, String endDate,
      String userCommunity, String tempAverage,
      String outputFormat, String lat, String lon, String bbox);


}
