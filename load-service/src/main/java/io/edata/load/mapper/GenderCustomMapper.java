package io.gentjankolicaj.app.edata.load.mapper;

import io.edata.commons.domain.Gender;
import io.gentjankolicaj.app.edata.load.command.GenderCmd;
import io.gentjankolicaj.app.edata.load.dto.GenderDTO;
import io.gentjankolicaj.app.edata.load.mapper.core.CustomMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenderCustomMapper implements CustomMapper<Gender, GenderDTO, GenderCmd> {

  public GenderCustomMapper() {
  }

  @Override
  public GenderDTO sourceToDto(Gender source) {
    if (source == null) {
      return null;
    } else {
      if (source.getValue().equals(Gender.F)) {
        return GenderDTO.F;
      } else if (source.getValue().equals(Gender.M)) {
        return GenderDTO.M;
      } else {
        return GenderDTO.O;
      }
    }
  }

  @Override
  public GenderCmd sourceToCommand(Gender source) {
    if (source == null) {
      return null;
    } else {
      if (source.getValue().equals(Gender.F)) {
        return GenderCmd.F;
      } else if (source.getValue().equals(Gender.M)) {
        return GenderCmd.M;
      } else {
        return GenderCmd.O;
      }
    }
  }

  @Override
  public Gender dtoToSource(GenderDTO dto) {
    if (dto == null) {
      return null;
    } else {
      if (dto.getValue().equals(GenderDTO.F)) {
        return Gender.F;
      } else if (dto.getValue().equals(GenderDTO.M)) {
        return Gender.M;
      } else {
        return Gender.O;
      }
    }
  }

  @Override
  public Gender commandToSource(GenderCmd command) {
    if (command == null) {
      return null;
    } else {
      if (command.getValue().equals(GenderCmd.F)) {
        return Gender.F;
      } else if (command.getValue().equals(GenderCmd.M)) {
        return Gender.M;
      } else {
        return Gender.O;
      }
    }
  }

  @Override
  public List<GenderDTO> sourceToDto(List<Gender> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<GenderDTO> tempList = new ArrayList<>(source.size());
      for (Gender temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<GenderCmd> sourceToCommand(List<Gender> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<GenderCmd> tempList = new ArrayList<>(source.size());
      for (Gender temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }

}
