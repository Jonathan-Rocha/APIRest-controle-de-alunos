package br.com.server.domain.instrument.dto;

import br.com.server.domain.instrument.Instrument;

public record InstrumentSearch(
        Long id,
        String instrument
) {
    public InstrumentSearch(Instrument instrument){
        this(
                instrument.getId(),
                instrument.getInstrument()
        );
    }
}
