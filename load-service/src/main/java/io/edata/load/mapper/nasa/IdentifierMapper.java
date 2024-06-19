package io.edata.load.mapper.nasa;

import io.edata.commons.domain.nasa.power.Identifier;
import io.edata.load.command.nasa.power.IdentifierCmd;
import io.edata.load.dto.nasa.power.IdentifierDTO;
import io.edata.load.mapper.core.NasaCustomMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class IdentifierMapper implements
    NasaCustomMapper<Identifier, IdentifierDTO, IdentifierCmd> {

  public IdentifierMapper() {
  }

  @Override
  public IdentifierDTO sourceToDto(Identifier source) {
    if (source == null) {
      return null;
    } else {
      IdentifierDTO identifierDTO = new IdentifierDTO();
      identifierDTO.setIdentifier(source.getIdentifier());
      return identifierDTO;
    }
  }

  @Override
  public IdentifierCmd sourceToCommand(Identifier source) {
    if (source == null) {
      return null;
    } else {
      IdentifierCmd identifierCmd = new IdentifierCmd();
      identifierCmd.setIdentifier(source.getIdentifier());
      return identifierCmd;
    }
  }

  @Override
  public Identifier dtoToSource(IdentifierDTO dto) {
    if (dto == null) {
      return null;
    } else {
      Identifier identifier = new Identifier();
      identifier.setIdentifier(dto.getIdentifier());
      return identifier;
    }
  }

  @Override
  public Identifier commandToSource(IdentifierCmd command) {
    if (command == null) {
      return null;
    } else {
      Identifier identifier = new Identifier();
      identifier.setIdentifier(command.getIdentifier());
      return identifier;
    }
  }

  @Override
  public List<IdentifierDTO> sourceToDto(List<Identifier> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<IdentifierDTO> tempList = new ArrayList<>(source.size());
      for (Identifier temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<IdentifierCmd> sourceToCommand(List<Identifier> source) {
    if (source == null || source.size() == 0) {
      return null;
    } else {
      List<IdentifierCmd> tempList = new ArrayList<>(source.size());
      for (Identifier temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<IdentifierDTO> sourceToDto(Iterable<Identifier> source) {
    if (source == null) {
      return null;
    } else {
      List<IdentifierDTO> tempList = new ArrayList<>();
      for (Identifier temp : source) {
        tempList.add(sourceToDto(temp));
      }
      return tempList;
    }
  }

  @Override
  public List<IdentifierCmd> sourceToCommand(Iterable<Identifier> source) {
    if (source == null) {
      return null;
    } else {
      List<IdentifierCmd> tempList = new ArrayList<>();
      for (Identifier temp : source) {
        tempList.add(sourceToCommand(temp));
      }
      return tempList;
    }
  }
}
