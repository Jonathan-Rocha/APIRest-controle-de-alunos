package br.com.server.domain.instrument.dto;

import br.com.server.domain.instrument.Instrument;

public record InstrumentData(

		Long id, 
		String instrument
		) {

	public InstrumentData(Instrument instrument) {
		this(
				instrument.getId(), 
				instrument.getInstrument()
			);
	}
}
