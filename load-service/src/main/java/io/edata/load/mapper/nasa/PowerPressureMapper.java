package io.edata.load.mapper.nasa;

import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.load.command.nasa.power.PowerPressureCmd;
import io.edata.load.dto.nasa.power.PowerPressureDTO;
import io.edata.load.mapper.PressureUnitMapper;
import io.edata.load.mapper.core.NasaCustomMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PowerPressureMapper implements
    NasaCustomMapper<PowerPressure, PowerPressureDTO, PowerPressureCmd> {

  private final PressureUnitMapper pressureUnitMapper;


  @Autowired
  public PowerPressureMapper() {
    this.pressureUnitMapper = PressureUnitMapper.INSTANCE;
  }

  @Override
  public PowerPressureDTO sourceToDto(PowerPressure source) {
    if (source == null) {
      return null;
    } else {
      PowerPressureDTO powerPressureDTO = new PowerPressureDTO();
      powerPressureDTO.setId(source.getId());
      powerPressureDTO.setValue(source.getValue());
      powerPressureDTO.setPressureUnitDTO(pressureUnitMapper.sourceToDto(source.getPressureUnit()));
      powerPressureDTO.setDate(source.getDate());
      return powerPressureDTO;
    }
  }

  @Override
  public PowerPressureCmd sourceToCommand(PowerPressure source) {
    if (source == null) {
      return null;
    } else {
      PowerPressureCmd powerPressureCmd = new PowerPressureCmd();
      powerPressureCmd.setId(source.getId());
      powerPressureCmd.setValue(source.getValue());
      powerPressureCmd.setPressureUnitCmd(
          pressureUnitMapper.sourceToCommand(source.getPressureUnit()));
      powerPressureCmd.setDate(source.getDate());
      return powerPressureCmd;
    }
  }

  @Override
  public PowerPressure dtoToSource(PowerPressureDTO dto) {
    if (dto == null) {
      return null;
    } else {
      PowerPressure powerPressure = new PowerPressure();
      powerPressure.setId(dto.getId());
      powerPressure.setValue(dto.getValue());
      powerPressure.setPressureUnit(pressureUnitMapper.dtoToSource(dto.getPressureUnitDTO()));
      powerPressure.setDate(dto.getDate());
      return powerPressure;
    }
  }

  @Override
  public PowerPressure commandToSource(PowerPressureCmd command) {
    if (command == null) {
      return null;
    } else {
      PowerPressure powerPressure = new PowerPressure();
      powerPressure.setId(command.getId());
      powerPressure.setValue(command.getValue());
      powerPressure.setPressureUnit(
          pressureUnitMapper.commandToSource(command.getPressureUnitCmd()));
      powerPressure.setDate(command.getDate());
      return powerPressure;
    }
  }

  @Override
  public List<PowerPressureDTO> sourceToDto(List<PowerPressure> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<PowerPressureDTO> tempList = new ArrayList<>(source.size());
      for (PowerPressure temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<PowerPressureCmd> sourceToCommand(List<PowerPressure> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<PowerPressureCmd> tempList = new ArrayList<>(source.size());
      for (PowerPressure temp : source) {
        tempList.add(sourceToCommand(temp));
      }

      return tempList;
    }
  }

  @Override
  public List<PowerPressureDTO> sourceToDto(Iterable<PowerPressure> source) {
    if (source == null) {
      return null;
    } else {
      List<PowerPressureDTO> tempList = new ArrayList<>();
      for (PowerPressure temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<PowerPressureCmd> sourceToCommand(Iterable<PowerPressure> source) {
    if (source == null) {
      return null;
    } else {
      List<PowerPressureCmd> tempList = new ArrayList<>();
      for (PowerPressure temp : source) {
        tempList.add(sourceToCommand(temp));
      }

      return tempList;
    }
  }

}
