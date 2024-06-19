package io.gentjankolicaj.app.edata.load.service;

import io.gentjankolicaj.app.edata.load.command.InformationCmd;
import io.gentjankolicaj.app.edata.load.repository.InformationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

  private final InformationRepository informationRepository;

  @Autowired
  public InformationServiceImpl(InformationRepository informationRepository) {
    this.informationRepository = informationRepository;
  }

  @Override
  public List<InformationCmd> getAllCommand() {
    return null;
  }

  @Override
  public InformationCmd saveCommand(InformationCmd informationCmd) {
    return null;
  }

  @Override
  public InformationCmd updateCommand(InformationCmd informationCmd) {
    return null;
  }

  @Override
  public InformationCmd getByIdCommand(Long id) {
    return null;
  }

  @Override
  public void deleteCommand(InformationCmd informationCmd) {

  }
}
