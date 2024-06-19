package io.gentjankolicaj.app.edata.load.service.nasa;

import io.edata.commons.domain.User;
import io.edata.commons.domain.nasa.power.PowerTemperature;
import io.edata.commons.enums.nasa.power.DataParameters;
import io.edata.commons.enums.nasa.power.Identifier;
import io.edata.commons.enums.nasa.power.OutputFormat;
import io.edata.commons.enums.nasa.power.TempAverage;
import io.edata.commons.enums.nasa.power.UserCommunity;
import io.gentjankolicaj.app.edata.load.command.nasa.power.PowerTemperatureCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerTemperatureDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.exception.resource.PowerTemperatureNotFoundException;
import io.gentjankolicaj.app.edata.load.mapper.nasa.PowerTemperatureMapper;
import io.gentjankolicaj.app.edata.load.repository.nasa.power.PowerTemperatureRepository;
import io.gentjankolicaj.app.edata.load.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerTemperatureServiceImpl implements PowerTemperatureService {

  private final PowerTemperatureRepository powerTemperatureRepository;
  private final PowerTemperatureMapper powerTemperatureMapper;
  private final UserService userService;


  @Autowired
  public PowerTemperatureServiceImpl(PowerTemperatureRepository powerTemperatureRepository,
      PowerTemperatureMapper powerTemperatureMapper, UserService userService) {
    this.powerTemperatureRepository = powerTemperatureRepository;
    this.powerTemperatureMapper = powerTemperatureMapper;
    this.userService = userService;
  }

  @Override
  public List<PowerTemperatureDTO> getAllDTO() {
    List<PowerTemperatureDTO> list = new ArrayList<>();
    Iterable<PowerTemperature> iterable = powerTemperatureRepository.findAll();
    for (PowerTemperature temp : iterable) {
      list.add(powerTemperatureMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<PowerTemperatureCmd> getAllCommand() {
    List<PowerTemperatureCmd> list = new ArrayList<>();
    Iterable<PowerTemperature> iterable = powerTemperatureRepository.findAll();
    for (PowerTemperature temp : iterable) {
      list.add(powerTemperatureMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public PowerTemperatureDTO saveDTO(PowerTemperatureDTO powerTemperatureDTO) {
    if (powerTemperatureDTO == null) {
      throw new NullReferenceException("PowerTemperature not saved.Reference passed is null !!!");
    } else {
      PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(
          powerTemperatureMapper.dtoToSource(powerTemperatureDTO));
      return powerTemperatureMapper.sourceToDto(savedPowerTemperature);
    }
  }

  @Override
  public PowerTemperatureCmd saveCommand(PowerTemperatureCmd powerTemperatureCmd) {
    if (powerTemperatureCmd == null) {
      throw new NullReferenceException("PowerTemperature not saved.Reference passed is null !!!");
    } else {
      PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(
          powerTemperatureMapper.commandToSource(powerTemperatureCmd));
      return powerTemperatureMapper.sourceToCommand(savedPowerTemperature);
    }
  }

  @Override
  public PowerTemperatureDTO updateDTO(PowerTemperatureDTO powerTemperatureDTO) {
    if (powerTemperatureDTO == null) {
      throw new NullReferenceException("PowerTemperature not updated.Reference passed is null !!!");
    } else {
      PowerTemperature newPowerTemperature = powerTemperatureMapper.dtoToSource(
          powerTemperatureDTO);
      Optional<PowerTemperature> optional = powerTemperatureRepository.findById(
          newPowerTemperature.getId());
      if (!optional.isPresent()) {
        PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(
            newPowerTemperature);
        return powerTemperatureMapper.sourceToDto(savedPowerTemperature);
      } else {
        PowerTemperature actual = optional.get();
        actual.setValue(newPowerTemperature.getValue());
        actual.setTemperatureUnit(newPowerTemperature.getTemperatureUnit());
        actual.setDate(newPowerTemperature.getDate());
        actual.setRawDataFormat(newPowerTemperature.getRawDataFormat());
        return powerTemperatureMapper.sourceToDto(actual);
      }
    }
  }

  @Override
  public PowerTemperatureCmd updateCommand(PowerTemperatureCmd powerTemperatureCmd) {
    if (powerTemperatureCmd == null) {
      throw new NullReferenceException("PowerTemperature not updated.Reference passed is null !!!");
    } else {
      PowerTemperature newPowerTemperature = powerTemperatureMapper.commandToSource(
          powerTemperatureCmd);
      Optional<PowerTemperature> optional = powerTemperatureRepository.findById(
          newPowerTemperature.getId());
      if (!optional.isPresent()) {
        PowerTemperature savedPowerTemperature = powerTemperatureRepository.save(
            newPowerTemperature);
        return powerTemperatureMapper.sourceToCommand(savedPowerTemperature);
      } else {
        PowerTemperature actual = optional.get();
        actual.setValue(newPowerTemperature.getValue());
        actual.setTemperatureUnit(newPowerTemperature.getTemperatureUnit());
        actual.setDate(newPowerTemperature.getDate());
        actual.setRawDataFormat(newPowerTemperature.getRawDataFormat());
        return powerTemperatureMapper.sourceToCommand(actual);
      }
    }
  }

  @Override
  public PowerTemperatureDTO getByIdDTO(Long id) {
    if (id == null) {
      throw new NullIdException("PowerTemperature id is null.");
    } else {
      Optional<PowerTemperature> optional = powerTemperatureRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PowerTemperatureNotFoundException(
            "PowerTemperature with id " + id + " not found.");
      } else {
        return powerTemperatureMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public PowerTemperatureCmd getByIdCommand(Long id) {
    if (id == null) {
      throw new NullIdException("PowerTemperature id is null.");
    } else {
      Optional<PowerTemperature> optional = powerTemperatureRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PowerTemperatureNotFoundException(
            "PowerTemperature with id " + id + " not found.");
      } else {
        return powerTemperatureMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(PowerTemperatureDTO powerTemperatureDTO) {
    if (powerTemperatureDTO == null) {
      throw new NullReferenceException("PowerTemperature not deleted.Reference passed is null !!!");
    } else {
      PowerTemperature powerTemperature = powerTemperatureMapper.dtoToSource(powerTemperatureDTO);
      powerTemperatureRepository.delete(powerTemperature);
    }
  }

  @Override
  public void deleteCommand(PowerTemperatureCmd powerTemperatureCmd) {
    if (powerTemperatureCmd == null) {
      throw new NullReferenceException("PowerTemperature not deleted.Reference passed is null !!!");
    } else {
      PowerTemperature powerTemperature = powerTemperatureMapper.commandToSource(
          powerTemperatureCmd);
      powerTemperatureRepository.delete(powerTemperature);
    }
  }

  @Override
  public List<PowerTemperatureDTO> retrieveDTO(Long userId, String identifier,
      String dataParameters, String startDate, String endDate, String userCommunity,
      String tempAverage, String outputFormat, String lat, String lon, String bbox) {
    Identifier identifierEnum = Identifier.valueOf(identifier);
    DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
    UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
    TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
    OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

    //Find user
    User user = userService.getById(userId);

    //Retrieve list
    List<PowerTemperature> retrievedList = null;//nasaClient.retrieveTemperature(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

    //Saved data to db
    Iterable<PowerTemperature> savedData = saveRetrievedList(retrievedList, user);

    return powerTemperatureMapper.sourceToDto(savedData);
  }

  @Override
  public List<PowerTemperatureCmd> retrieveCommand(Long userId, String identifier,
      String dataParameters, String startDate, String endDate, String userCommunity,
      String tempAverage, String outputFormat, String lat, String lon, String bbox) {
    Identifier identifierEnum = Identifier.valueOf(identifier);
    DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
    UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
    TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
    OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

    //Find user
    User user = userService.getById(userId);

    //Retrieve list
    List<PowerTemperature> retrievedList = null;//nasaClient.retrieveTemperature(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

    //Saved data to db
    Iterable<PowerTemperature> savedData = saveRetrievedList(retrievedList, user);

    return powerTemperatureMapper.sourceToCommand(savedData);
  }


  private Iterable<PowerTemperature> saveRetrievedList(List<PowerTemperature> retrievedList,
      User user) {
    return powerTemperatureRepository.saveAll(retrievedList);
  }

}
