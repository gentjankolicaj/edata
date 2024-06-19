package io.gentjankolicaj.app.edata.load.mapper.nasa;

import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.app.edata.load.command.nasa.power.PowerTemperatureCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerTemperatureDTO;
import io.gentjankolicaj.app.edata.load.mapper.TemperatureUnitMapper;
import io.gentjankolicaj.app.edata.load.mapper.core.NasaCustomMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class PowerTemperatureMapper implements
    NasaCustomMapper<PowerTemperature, PowerTemperatureDTO, PowerTemperatureCmd> {


  private final TemperatureUnitMapper temperatureUnitMapper;

  public PowerTemperatureMapper() {
    this.temperatureUnitMapper = TemperatureUnitMapper.INSTANCE;
  }

  @Override
  public PowerTemperatureDTO sourceToDto(PowerTemperature source) {
    if (source == null) {
      return null;
    } else {
      PowerTemperatureDTO powerTemperatureDTO = new PowerTemperatureDTO();
      powerTemperatureDTO.setId(source.getId());
      powerTemperatureDTO.setValue(source.getValue());
      powerTemperatureDTO.setTemperatureUnitDTO(
          temperatureUnitMapper.sourceToDto(source.getTemperatureUnit()));
      powerTemperatureDTO.setDate(source.getDate());
      return powerTemperatureDTO;
    }
  }

  @Override
  public PowerTemperatureCmd sourceToCommand(PowerTemperature source) {
    if (source == null) {
      return null;
    } else {
      PowerTemperatureCmd powerTemperatureCmd = new PowerTemperatureCmd();
      powerTemperatureCmd.setId(source.getId());
      powerTemperatureCmd.setValue(source.getValue());
      powerTemperatureCmd.setTemperatureUnitCmd(
          temperatureUnitMapper.sourceToCommand(source.getTemperatureUnit()));
      powerTemperatureCmd.setDate(source.getDate());
      return powerTemperatureCmd;

    }
  }

  @Override
  public PowerTemperature dtoToSource(PowerTemperatureDTO dto) {
    if (dto == null) {
      return null;
    } else {
      PowerTemperature powerTemperature = new PowerTemperature();
      powerTemperature.setId(dto.getId());
      powerTemperature.setValue(dto.getValue());
      powerTemperature.setTemperatureUnit(
          temperatureUnitMapper.dtoToSource(dto.getTemperatureUnitDTO()));
      powerTemperature.setDate(dto.getDate());
      return powerTemperature;
    }
  }

  @Override
  public PowerTemperature commandToSource(PowerTemperatureCmd command) {
    if (command == null) {
      return null;
    } else {
      PowerTemperature powerTemperature = new PowerTemperature();
      powerTemperature.setId(command.getId());
      powerTemperature.setValue(command.getValue());
      powerTemperature.setTemperatureUnit(
          temperatureUnitMapper.commandToSource(command.getTemperatureUnitCmd()));
      powerTemperature.setDate(command.getDate());
      return powerTemperature;
    }
  }

  @Override
  public List<PowerTemperatureDTO> sourceToDto(List<PowerTemperature> source) {
    if (source == null || source.isEmpty()) {
      return null;
    } else {
      List<PowerTemperatureDTO> tempList = new ArrayList<>(source.size());
      for (PowerTemperature temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<PowerTemperatureCmd> sourceToCommand(List<PowerTemperature> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<PowerTemperatureCmd> tempList = new ArrayList<>(source.size());
      for (PowerTemperature temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<PowerTemperatureDTO> sourceToDto(Iterable<PowerTemperature> source) {
    if (source == null) {
      return null;
    } else {
      List<PowerTemperatureDTO> tempList = new ArrayList<>();
      for (PowerTemperature temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<PowerTemperatureCmd> sourceToCommand(Iterable<PowerTemperature> source) {
    if (source == null) {
      return null;
    } else {
      List<PowerTemperatureCmd> tempList = new ArrayList<>();
      for (PowerTemperature temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }

}
