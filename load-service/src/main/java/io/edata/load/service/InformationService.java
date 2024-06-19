package io.gentjankolicaj.app.edata.load.service;

import io.gentjankolicaj.app.edata.load.command.InformationCmd;
import java.util.List;

public interface InformationService {

  List<InformationCmd> getAllCommand();

  InformationCmd saveCommand(InformationCmd informationCmd);

  InformationCmd updateCommand(InformationCmd informationCmd);

  InformationCmd getByIdCommand(Long id);

  void deleteCommand(InformationCmd informationCmd);
}
