package io.gentjankolicaj.app.edata.load.service;

import io.edata.commons.domain.PressureUnit;
import io.gentjankolicaj.app.edata.load.command.PressureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.PressureUnitDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.exception.resource.PressureUnitNotFoundException;
import io.gentjankolicaj.app.edata.load.mapper.PressureUnitMapper;
import io.gentjankolicaj.app.edata.load.repository.PressureUnitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PressureUnitServiceImpl implements PressureUnitService {

  private final PressureUnitRepository pressureUnitRepository;
  private final PressureUnitMapper pressureUnitMapper;

  @Autowired
  public PressureUnitServiceImpl(PressureUnitRepository pressureUnitRepository) {
    this.pressureUnitRepository = pressureUnitRepository;
    this.pressureUnitMapper = PressureUnitMapper.INSTANCE;
  }

  @Override
  public List<PressureUnitDTO> getAllDTO() {
    List<PressureUnitDTO> list = new ArrayList<>();
    Iterable<PressureUnit> iterable = pressureUnitRepository.findAll();
    for (PressureUnit temp : iterable) {
      list.add(pressureUnitMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<PressureUnitCmd> getAllCommand() {
    List<PressureUnitCmd> list = new ArrayList<>();
    Iterable<PressureUnit> iterable = pressureUnitRepository.findAll();
    for (PressureUnit temp : iterable) {
      list.add(pressureUnitMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public PressureUnitDTO saveDTO(PressureUnitDTO pressureUnitDTO) {
    if (pressureUnitDTO == null) {
      throw new NullReferenceException("PressureUnit not saved.Reference passed is null !!!");
    } else {
      PressureUnit savedPressureUnit = pressureUnitRepository.save(
          pressureUnitMapper.dtoToSource(pressureUnitDTO));
      return pressureUnitMapper.sourceToDto(savedPressureUnit);
    }
  }

  @Override
  public PressureUnitCmd saveCommand(PressureUnitCmd pressureUnitCmd) {
    if (pressureUnitCmd == null) {
      throw new NullReferenceException("PressureUnit not saved.Reference passed is null !!!");
    } else {
      PressureUnit savedPressureUnit = pressureUnitRepository.save(
          pressureUnitMapper.commandToSource(pressureUnitCmd));
      return pressureUnitMapper.sourceToCommand(savedPressureUnit);
    }
  }

  @Override
  public PressureUnitDTO updateDTO(PressureUnitDTO pressureUnitDTO) {
    if (pressureUnitDTO == null) {
      throw new NullReferenceException("PressureUnit not updated.Reference passed is null !!!");
    } else {
      PressureUnit newPressureUnit = pressureUnitMapper.dtoToSource(pressureUnitDTO);
      Optional<PressureUnit> optional = pressureUnitRepository.findById(
          newPressureUnit.getUnitCode());
      if (!optional.isPresent()) {
        PressureUnit savedPressureUnit = pressureUnitRepository.save(newPressureUnit);
        return pressureUnitMapper.sourceToDto(savedPressureUnit);
      } else {
        PressureUnit actual = optional.get();
        actual.setUnitName(newPressureUnit.getUnitName());
        actual.setUnitDescription(newPressureUnit.getUnitDescription());
        return pressureUnitMapper.sourceToDto(actual);
      }

    }
  }

  @Override
  public PressureUnitCmd updateCommand(PressureUnitCmd pressureUnitCmd) {
    if (pressureUnitCmd == null) {
      throw new NullReferenceException("PressureUnit not updated.Reference passed is null !!!");
    } else {
      PressureUnit newPressureUnit = pressureUnitMapper.commandToSource(pressureUnitCmd);
      Optional<PressureUnit> optional = pressureUnitRepository.findById(
          newPressureUnit.getUnitCode());
      if (!optional.isPresent()) {
        PressureUnit savedPressureUnit = pressureUnitRepository.save(newPressureUnit);
        return pressureUnitMapper.sourceToCommand(savedPressureUnit);
      } else {
        PressureUnit actual = optional.get();
        actual.setUnitName(newPressureUnit.getUnitName());
        actual.setUnitDescription(newPressureUnit.getUnitDescription());
        return pressureUnitMapper.sourceToCommand(actual);
      }

    }
  }

  @Override
  public PressureUnitDTO getByIdDTO(String id) {
    if (id == null) {
      throw new NullIdException("PressureUnit id is null.");
    } else {
      Optional<PressureUnit> optional = pressureUnitRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PressureUnitNotFoundException("PressureUnit with id " + id + " not found.");
      } else {
        return pressureUnitMapper.sourceToDto(optional.get());
      }
    }

  }

  @Override
  public PressureUnitCmd getByIdCommand(String id) {
    if (id == null) {
      throw new NullIdException("PressureUnit id is null.");
    } else {
      Optional<PressureUnit> optional = pressureUnitRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PressureUnitNotFoundException("PressureUnit with id " + id + " not found.");
      } else {
        return pressureUnitMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(PressureUnitDTO pressureUnitDTO) {
    if (pressureUnitDTO == null) {
      throw new NullReferenceException("PressureUnit not deleted.Reference passed is null !!!");
    } else {
      PressureUnit pressureUnit = pressureUnitMapper.dtoToSource(pressureUnitDTO);
      pressureUnitRepository.delete(pressureUnit);
    }

  }

  @Override
  public void deleteCommand(PressureUnitCmd pressureUnitCmd) {
    if (pressureUnitCmd == null) {
      throw new NullReferenceException("PressureUnit not deleted.Reference passed is null !!!");
    } else {
      PressureUnit pressureUnit = pressureUnitMapper.commandToSource(pressureUnitCmd);
      pressureUnitRepository.delete(pressureUnit);
    }
  }

  @Override
  public List<PressureUnitDTO> getByUnitNameDTO(String unitName) {
    if (unitName == null) {
      throw new NullReferenceException("PressureUnits not found.Reference passed is null !!!");
    } else {
      List<PressureUnit> tempList = pressureUnitRepository.findPressureUnitByUnitNameLike(unitName);
      return pressureUnitMapper.sourceToDto(tempList);
    }
  }

  @Override
  public List<PressureUnitCmd> getByUnitNameCommand(String unitName) {
    if (unitName == null) {
      throw new NullReferenceException("PressureUnits not found.Reference passed is null !!!");
    } else {
      List<PressureUnit> tempList = pressureUnitRepository.findPressureUnitByUnitNameLike(unitName);
      return pressureUnitMapper.sourceToCommand(tempList);
    }
  }
}
