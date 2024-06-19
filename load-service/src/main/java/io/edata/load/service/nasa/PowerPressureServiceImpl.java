package io.gentjankolicaj.app.edata.load.service.nasa;


import io.edata.commons.domain.User;
import io.edata.commons.domain.nasa.power.PowerPressure;
import io.edata.commons.enums.nasa.power.DataParameters;
import io.edata.commons.enums.nasa.power.Identifier;
import io.edata.commons.enums.nasa.power.OutputFormat;
import io.edata.commons.enums.nasa.power.TempAverage;
import io.edata.commons.enums.nasa.power.UserCommunity;
import io.gentjankolicaj.app.edata.load.command.nasa.power.PowerPressureCmd;
import io.gentjankolicaj.app.edata.load.dto.nasa.power.PowerPressureDTO;
import io.gentjankolicaj.app.edata.load.exception.resource.NullIdException;
import io.gentjankolicaj.app.edata.load.exception.resource.NullReferenceException;
import io.gentjankolicaj.app.edata.load.exception.resource.PowerPressureNotFoundException;
import io.gentjankolicaj.app.edata.load.mapper.nasa.PowerPressureMapper;
import io.gentjankolicaj.app.edata.load.repository.nasa.power.PowerPressureRepository;
import io.gentjankolicaj.app.edata.load.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerPressureServiceImpl implements PowerPressureService {

  private final PowerPressureRepository powerPressureRepository;
  private final PowerPressureMapper powerPressureMapper;

  private final UserService userService;


  @Autowired
  public PowerPressureServiceImpl(PowerPressureRepository powerPressureRepository,
      PowerPressureMapper powerPressureMapper, UserService userService) {
    this.powerPressureRepository = powerPressureRepository;
    this.powerPressureMapper = powerPressureMapper;
    this.userService = userService;
  }

  @Override
  public List<PowerPressureDTO> getAllDTO() {
    List<PowerPressureDTO> list = new ArrayList<>();
    Iterable<PowerPressure> iterable = powerPressureRepository.findAll();
    for (PowerPressure temp : iterable) {
      list.add(powerPressureMapper.sourceToDto(temp));
    }
    return list;
  }

  @Override
  public List<PowerPressureCmd> getAllCommand() {
    List<PowerPressureCmd> list = new ArrayList<>();
    Iterable<PowerPressure> iterable = powerPressureRepository.findAll();
    for (PowerPressure temp : iterable) {
      list.add(powerPressureMapper.sourceToCommand(temp));
    }
    return list;
  }

  @Override
  public PowerPressureDTO saveDTO(PowerPressureDTO powerPressureDTO) {
    if (powerPressureDTO == null) {
      throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
    } else {
      PowerPressure savedPowerPressure = powerPressureRepository.save(
          powerPressureMapper.dtoToSource(powerPressureDTO));
      return powerPressureMapper.sourceToDto(savedPowerPressure);
    }
  }

  @Override
  public PowerPressureCmd saveCommand(PowerPressureCmd powerPressureCmd) {
    if (powerPressureCmd == null) {
      throw new NullReferenceException("PowerPressure not saved.Reference passed is null !!!");
    } else {
      PowerPressure savedPowerPressure = powerPressureRepository.save(
          powerPressureMapper.commandToSource(powerPressureCmd));
      return powerPressureMapper.sourceToCommand(savedPowerPressure);
    }
  }

  @Override
  public PowerPressureDTO updateDTO(PowerPressureDTO powerPressureDTO) {
    if (powerPressureDTO == null) {
      throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
    } else {
      PowerPressure newPowerPressure = powerPressureMapper.dtoToSource(powerPressureDTO);
      Optional<PowerPressure> optional = powerPressureRepository.findById(newPowerPressure.getId());
      if (!optional.isPresent()) {
        PowerPressure savedPowerPressure = powerPressureRepository.save(newPowerPressure);
        return powerPressureMapper.sourceToDto(savedPowerPressure);
      } else {
        PowerPressure actual = optional.get();
        actual.setValue(newPowerPressure.getValue());
        actual.setPressureUnit(newPowerPressure.getPressureUnit());
        actual.setDate(newPowerPressure.getDate());
        actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
        return powerPressureMapper.sourceToDto(actual);
      }
    }
  }

  @Override
  public PowerPressureCmd updateCommand(PowerPressureCmd powerPressureCmd) {
    if (powerPressureCmd == null) {
      throw new NullReferenceException("PowerPressure not updated.Reference passed is null !!!");
    } else {
      PowerPressure newPowerPressure = powerPressureMapper.commandToSource(powerPressureCmd);
      Optional<PowerPressure> optional = powerPressureRepository.findById(newPowerPressure.getId());
      if (!optional.isPresent()) {
        PowerPressure savedPowerPressure = powerPressureRepository.save(newPowerPressure);
        return powerPressureMapper.sourceToCommand(savedPowerPressure);
      } else {
        PowerPressure actual = optional.get();
        actual.setValue(newPowerPressure.getValue());
        actual.setPressureUnit(newPowerPressure.getPressureUnit());
        actual.setDate(newPowerPressure.getDate());
        actual.setRawDataFormat(newPowerPressure.getRawDataFormat());
        return powerPressureMapper.sourceToCommand(actual);
      }
    }
  }

  @Override
  public PowerPressureDTO getByIdDTO(Long id) {
    if (id == null) {
      throw new NullIdException("PowerPressure id is null.");
    } else {
      Optional<PowerPressure> optional = powerPressureRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PowerPressureNotFoundException("PowerPressure with id " + id + " not found.");
      } else {
        return powerPressureMapper.sourceToDto(optional.get());
      }
    }
  }

  @Override
  public PowerPressureCmd getByIdCommand(Long id) {
    if (id == null) {
      throw new NullIdException("PowerPressure id is null.");
    } else {
      Optional<PowerPressure> optional = powerPressureRepository.findById(id);
      if (!optional.isPresent()) {
        throw new PowerPressureNotFoundException("PowerPressure with id " + id + " not found.");
      } else {
        return powerPressureMapper.sourceToCommand(optional.get());
      }
    }
  }

  @Override
  public void deleteDTO(PowerPressureDTO powerPressureDTO) {
    if (powerPressureDTO == null) {
      throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
    } else {
      PowerPressure powerPressure = powerPressureMapper.dtoToSource(powerPressureDTO);
      powerPressureRepository.delete(powerPressure);
    }
  }

  @Override
  public void deleteCommand(PowerPressureCmd powerPressureCmd) {
    if (powerPressureCmd == null) {
      throw new NullReferenceException("PowerPressure not deleted.Reference passed is null !!!");
    } else {
      PowerPressure powerPressure = powerPressureMapper.commandToSource(powerPressureCmd);
      powerPressureRepository.delete(powerPressure);
    }
  }

  @Override
  public List<PowerPressureDTO> retrieveDTO(Long userId, String identifier, String dataParameters,
      String startDate, String endDate, String userCommunity, String tempAverage,
      String outputFormat, String lat, String lon, String bbox) {
    Identifier identifierEnum = Identifier.valueOf(identifier);
    DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
    UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
    TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
    OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

    //Find user
    User user = userService.getById(userId);

    //Retrieved data.
    List<PowerPressure> retrievedList = null;//nasaClient.retrievePressure(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

    //Save data to db
    Iterable<PowerPressure> savedData = saveRetrievedData(retrievedList, user);

    return powerPressureMapper.sourceToDto(savedData);

  }

  @Override
  public List<PowerPressureCmd> retrieveCommand(Long userId, String identifier,
      String dataParameters, String startDate, String endDate, String userCommunity,
      String tempAverage, String outputFormat, String lat, String lon, String bbox) {
    Identifier identifierEnum = Identifier.valueOf(identifier);
    DataParameters dataParametersEnum = DataParameters.valueOf(dataParameters);
    UserCommunity userCommunityEnum = UserCommunity.valueOf(userCommunity);
    TempAverage tempAverageEnum = TempAverage.valueOf(tempAverage);
    OutputFormat outputFormatEnum = OutputFormat.valueOf(outputFormat);

    //Find user
    User user = userService.getById(userId);

    //Retrieved data.
    List<PowerPressure> retrievedList = null;// nasaClient.retrievePressure(identifierEnum, dataParametersEnum, startDate, endDate, userCommunityEnum, tempAverageEnum, outputFormatEnum, lat, lon, bbox);

    //Saved data to db
    Iterable<PowerPressure> savedData = saveRetrievedData(retrievedList, user);

    return powerPressureMapper.sourceToCommand(savedData);
  }


  private Iterable<PowerPressure> saveRetrievedData(List<PowerPressure> retrievedList, User user) {
    return powerPressureRepository.saveAll(retrievedList);
  }


}
