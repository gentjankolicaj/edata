package io.gentjankolicaj.app.edata.load.service;

import io.edata.commons.domain.TemperatureUnit;
import io.gentjankolicaj.app.edata.load.command.TemperatureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.TemperatureUnitDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.exception.resource.TemperatureUnitNotFoundException;
import io.gentjankolicaj.app.edata.load.mapper.TemperatureUnitMapper;
import io.gentjankolicaj.app.edata.load.repository.TemperatureUnitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TemperatureUnitServiceImpl implements TemperatureUnitService {

  private final TemperatureUnitRepository temperatureUnitRepository;
  private final TemperatureUnitMapper temperatureUnitMapper;

  public TemperatureUnitServiceImpl(TemperatureUnitRepository temperatureUnitRepository) {
    this.temperatureUnitRepository = temperatureUnitRepository;
    this.temperatureUnitMapper = TemperatureUnitMapper.INSTANCE;
  }

  @Override
  public List<TemperatureUnitDTO> getAllDTO() {
    List<TemperatureUnitDTO> list = new ArrayList<>();
    Iterable<TemperatureUnit> iterable = temperatureUnitRepository.findAll();
    for (TemperatureUnit temp : iterable) {
      list.add(temperatureUnitMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<TemperatureUnitCmd> getAllCommand() {
    List<TemperatureUnitCmd> list = new ArrayList<>();
    Iterable<TemperatureUnit> iterable = temperatureUnitRepository.findAll();
    for (TemperatureUnit temp : iterable) {
      list.add(temperatureUnitMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public TemperatureUnitDTO saveDTO(TemperatureUnitDTO temperatureUnitDTO) {
    if (temperatureUnitDTO == null) {
      throw new NullReferenceException("TemperatureUnit not saved.Reference passed is null !!!");
    } else {
      TemperatureUnit savedTemperatureUnit = temperatureUnitRepository.save(
          temperatureUnitMapper.dtoToSource(temperatureUnitDTO));
      return temperatureUnitMapper.sourceToDto(savedTemperatureUnit);
    }
  }

  @Override
  public TemperatureUnitCmd saveCommand(TemperatureUnitCmd temperatureUnitCmd) {
    if (temperatureUnitCmd == null) {
      throw new NullReferenceException("TemperatureUnit not saved.Reference passed is null !!!");
    } else {
      TemperatureUnit savedTemperatureUnit = temperatureUnitRepository.save(
          temperatureUnitMapper.commandToSource(temperatureUnitCmd));
      return temperatureUnitMapper.sourceToCommand(savedTemperatureUnit);
    }
  }

  @Override
  public TemperatureUnitDTO updateDTO(TemperatureUnitDTO temperatureUnitDTO) {
    if (temperatureUnitDTO == null) {
      throw new NullReferenceException("TemperatureUnit not updated.Reference passed is null !!!");
    } else {
      TemperatureUnit newTemperatureUnit = temperatureUnitMapper.dtoToSource(temperatureUnitDTO);
      Optional<TemperatureUnit> optional = temperatureUnitRepository.findById(
          newTemperatureUnit.getUnitCode());
      if (!optional.isPresent()) {
        TemperatureUnit savedTemperatureUnit = temperatureUnitRepository.save(newTemperatureUnit);
        return temperatureUnitMapper.sourceToDto(savedTemperatureUnit);
      } else {
        TemperatureUnit actual = optional.get();
        actual.setUnitDescription(newTemperatureUnit.getUnitDescription());
        actual.setUnitName(newTemperatureUnit.getUnitName());
        return temperatureUnitMapper.sourceToDto(actual);
      }
    }
  }

  @Override
  public TemperatureUnitCmd updateCommand(TemperatureUnitCmd temperatureUnitCmd) {
    if (temperatureUnitCmd == null) {
      throw new NullReferenceException("TemperatureUnit not updated.Reference passed is null !!!");
    } else {
      TemperatureUnit newTemperatureUnit = temperatureUnitMapper.commandToSource(
          temperatureUnitCmd);
      Optional<TemperatureUnit> optional = temperatureUnitRepository.findById(
          newTemperatureUnit.getUnitCode());
      if (!optional.isPresent()) {
        TemperatureUnit savedTemperatureUnit = temperatureUnitRepository.save(newTemperatureUnit);
        return temperatureUnitMapper.sourceToCommand(savedTemperatureUnit);
      } else {
        TemperatureUnit actual = optional.get();
        actual.setUnitDescription(newTemperatureUnit.getUnitDescription());
        actual.setUnitName(newTemperatureUnit.getUnitName());
        return temperatureUnitMapper.sourceToCommand(actual);
      }
    }
  }

  @Override
  public TemperatureUnitDTO getByIdDTO(String id) {
    if (id == null) {
      throw new NullIdException("TemperatureUnit id is null.");
    } else {
      Optional<TemperatureUnit> optional = temperatureUnitRepository.findById(id);
      if (!optional.isPresent()) {
        throw new TemperatureUnitNotFoundException("TemperatureUnit with id " + id + " not found.");
      } else {
        return temperatureUnitMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public TemperatureUnitCmd getByIdCommand(String id) {
    if (id == null) {
      throw new NullIdException("TemperatureUnit id is null.");
    } else {
      Optional<TemperatureUnit> optional = temperatureUnitRepository.findById(id);
      if (!optional.isPresent()) {
        throw new TemperatureUnitNotFoundException("TemperatureUnit with id " + id + " not found.");
      } else {
        return temperatureUnitMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(TemperatureUnitDTO temperatureUnitDTO) {
    if (temperatureUnitDTO == null) {
      throw new NullReferenceException("TemperatureUnit not deleted.Reference passed is null !!!");
    } else {
      TemperatureUnit temperatureUnit = temperatureUnitMapper.dtoToSource(temperatureUnitDTO);
      temperatureUnitRepository.delete(temperatureUnit);
    }

  }

  @Override
  public void deleteCommand(TemperatureUnitCmd temperatureUnitCmd) {
    if (temperatureUnitCmd == null) {
      throw new NullReferenceException("TemperatureUnit not deleted.Reference passed is null !!!");
    } else {
      TemperatureUnit temperatureUnit = temperatureUnitMapper.commandToSource(temperatureUnitCmd);
      temperatureUnitRepository.delete(temperatureUnit);
    }
  }

  @Override
  public List<TemperatureUnitDTO> getByUnitNameDTO(String unitName) {
    return null;
  }

  @Override
  public List<TemperatureUnitCmd> getByUnitNameCommand(String unitName) {
    return null;
  }
}
