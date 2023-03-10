package br.com.server.domain.instrument.service;

import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.instrument.InstrumentRepository;
import br.com.server.domain.instrument.dto.InstrumentCreate;
import br.com.server.domain.instrument.dto.InstrumentData;
import br.com.server.domain.instrument.dto.InstrumentUpdate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstrumentService {

  private final InstrumentRepository instrumentRepository;

  public Instrument create(InstrumentCreate data) {
    return instrumentRepository.save(new Instrument(data));
  }

  public Page<InstrumentData> findAll(Pageable pageable) {
    return instrumentRepository.findAll(pageable).map(InstrumentData::new);
  }

  public Instrument findById(Long id) {
    return instrumentRepository.getReferenceById(id);
  }

  public Instrument update(Long id, InstrumentUpdate data) {
    var instrument = instrumentRepository.getReferenceById(id);
    if (data.instrument() != null) {
      instrument.setInstrument(data.instrument());
    }
    return instrument;
  }
}
