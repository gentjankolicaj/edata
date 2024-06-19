package io.gentjankolicaj.app.edata.load.mapper.core;

import java.util.List;

public interface NasaCustomMapper<S, D, C> {


  D sourceToDto(S source);

  C sourceToCommand(S source);

  S dtoToSource(D dto);

  S commandToSource(C command);

  List<D> sourceToDto(List<S> source);

  List<C> sourceToCommand(List<S> source);

  List<D> sourceToDto(Iterable<S> source);

  List<C> sourceToCommand(Iterable<S> source);

}
