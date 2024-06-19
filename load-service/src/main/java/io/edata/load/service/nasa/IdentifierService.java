package io.gentjankolicaj.app.edata.load.service.nasa;

import io.gentjankolicaj.app.edata.load.command.nasa.power.IdentifierCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.IdentifierDTO;
import java.util.List;

public interface IdentifierService {

  List<IdentifierDTO> getAllDTO();

  List<IdentifierCmd> getAllCommand();

  IdentifierDTO saveDTO(IdentifierDTO identifierDTO);

  IdentifierCmd saveCommand(IdentifierCmd identifierCmd);

  IdentifierDTO updateDTO(IdentifierDTO identifierDTO);

  IdentifierCmd updateCommand(IdentifierCmd identifierCmd);

  IdentifierDTO getByIdDTO(String id);

  IdentifierCmd getByIdCommand(String id);

  void deleteDTO(IdentifierDTO identifierDTO);

  void deleteCommand(IdentifierCmd identifierCmd);


}
