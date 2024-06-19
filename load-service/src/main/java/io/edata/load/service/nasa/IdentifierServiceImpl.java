package io.gentjankolicaj.app.edata.load.service.nasa;

import io.edata.commons.domain.nasa.power.Identifier;
import io.gentjankolicaj.app.edata.load.command.nasa.power.IdentifierCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.IdentifierDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.IdentifierNotFoundException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.mapper.nasa.IdentifierMapper;
import io.gentjankolicaj.app.edata.load.repository.nasa.power.IdentifierRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentifierServiceImpl implements IdentifierService {

  private final IdentifierRepository identifierRepository;
  private final IdentifierMapper identifierMapper;

  @Autowired
  public IdentifierServiceImpl(IdentifierRepository identifierRepository,
      IdentifierMapper identifierMapper) {
    this.identifierRepository = identifierRepository;
    this.identifierMapper = identifierMapper;
  }

  @Override
  public List<IdentifierDTO> getAllDTO() {
    List<IdentifierDTO> list = new ArrayList<>();
    Iterable<Identifier> iterable = identifierRepository.findAll();
    for (Identifier temp : iterable) {
      list.add(identifierMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<IdentifierCmd> getAllCommand() {
    List<IdentifierCmd> list = new ArrayList<>();
    Iterable<Identifier> iterable = identifierRepository.findAll();
    for (Identifier temp : iterable) {
      list.add(identifierMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public IdentifierDTO saveDTO(IdentifierDTO identifierDTO) {
    if (identifierDTO == null) {
      throw new NullReferenceException("Identifier not saved.Reference passed is null !!!");
    } else {
      Identifier savedObject = identifierRepository.save(
          identifierMapper.dtoToSource(identifierDTO));
      return identifierMapper.sourceToDto(savedObject);
    }
  }

  @Override
  public IdentifierCmd saveCommand(IdentifierCmd identifierCmd) {
    if (identifierCmd == null) {
      throw new NullReferenceException("Identifier not saved.Reference passed is null !!!");
    } else {
      Identifier savedObject = identifierRepository.save(
          identifierMapper.commandToSource(identifierCmd));
      return identifierMapper.sourceToCommand(savedObject);
    }
  }

  @Override
  public IdentifierDTO updateDTO(IdentifierDTO identifierDTO) {
    if (identifierDTO == null) {
      throw new NullReferenceException("Identifier not found.Reference passed is null !!!");
    } else {
      Identifier identifier = identifierMapper.dtoToSource(identifierDTO);
      Optional<Identifier> optional = identifierRepository.findById(identifier.getIdentifier());
      if (!optional.isPresent()) {
        IdentifierDTO updated = identifierMapper.sourceToDto(identifierRepository.save(identifier));
        return updated;
      } else {
        return identifierMapper.sourceToDto(optional.get());
      }
    }

  }

  @Override
  public IdentifierCmd updateCommand(IdentifierCmd identifierCmd) {
    if (identifierCmd == null) {
      throw new NullReferenceException("Identifier not found.Reference passed is null !!!");
    } else {
      Identifier identifier = identifierMapper.commandToSource(identifierCmd);
      Optional<Identifier> optional = identifierRepository.findById(identifier.getIdentifier());
      if (!optional.isPresent()) {
        IdentifierCmd updated = identifierMapper.sourceToCommand(
            identifierRepository.save(identifier));
        return updated;
      } else {
        return identifierMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public IdentifierDTO getByIdDTO(String id) {
    if (id == null) {
      throw new NullIdException("Identifier id is null.");
    } else {
      Optional<Identifier> optional = identifierRepository.findById(id);
      if (!optional.isPresent()) {
        throw new IdentifierNotFoundException("Identifier with id " + id + " not found.");
      } else {
        return identifierMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public IdentifierCmd getByIdCommand(String id) {
    if (id == null) {
      throw new NullIdException("Identifier id is null.");
    } else {
      Optional<Identifier> optional = identifierRepository.findById(id);
      if (!optional.isPresent()) {
        throw new IdentifierNotFoundException("Identifier with id " + id + " not found.");
      } else {
        return identifierMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(IdentifierDTO identifierDTO) {
    if (identifierDTO == null) {
      throw new NullReferenceException("Identifier not deleted.Reference passed is null !!!");

    } else {
      Identifier identifier = identifierMapper.dtoToSource(identifierDTO);
      identifierRepository.delete(identifier);
    }
  }

  @Override
  public void deleteCommand(IdentifierCmd identifierCmd) {
    if (identifierCmd == null) {
      throw new NullReferenceException("Identifier not deleted.Reference passed is null !!!");

    } else {
      Identifier identifier = identifierMapper.commandToSource(identifierCmd);
      identifierRepository.delete(identifier);
    }
  }


}
