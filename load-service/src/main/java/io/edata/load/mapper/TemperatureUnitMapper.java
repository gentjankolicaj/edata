package io.gentjankolicaj.app.edata.load.mapper;

import io.edata.commons.domain.TemperatureUnit;
import io.gentjankolicaj.app.edata.load.command.TemperatureUnitCmd;
import io.gentjankolicaj.app.edata.load.dto.TemperatureUnitDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemperatureUnitMapper {

  TemperatureUnitMapper INSTANCE = Mappers.getMapper(TemperatureUnitMapper.class);

  @Mapping(source = "unitCode", target = "unitCode")
  @Mapping(source = "unitName", target = "unitName")
  @Mapping(source = "unitDescription", target = "unitDescription")
  TemperatureUnitDTO sourceToDto(TemperatureUnit source);

  @Mapping(source = "unitCode", target = "unitCode")
  @Mapping(source = "unitName", target = "unitName")
  @Mapping(source = "unitDescription", target = "unitDescription")
  TemperatureUnitCmd sourceToCommand(TemperatureUnit source);

  @Mapping(source = "unitCode", target = "unitCode")
  @Mapping(source = "unitName", target = "unitName")
  @Mapping(source = "unitDescription", target = "unitDescription")
  TemperatureUnit dtoToSource(TemperatureUnitDTO dto);

  @Mapping(source = "unitCode", target = "unitCode")
  @Mapping(source = "unitName", target = "unitName")
  @Mapping(source = "unitDescription", target = "unitDescription")
  TemperatureUnit commandToSource(TemperatureUnitCmd command);

  List<TemperatureUnitDTO> sourceToDto(List<TemperatureUnit> source);

  List<TemperatureUnitCmd> sourceToCommand(List<TemperatureUnit> source);
}
