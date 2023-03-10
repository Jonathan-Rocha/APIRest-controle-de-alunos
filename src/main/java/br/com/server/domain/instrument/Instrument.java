package br.com.server.domain.instrument;

import br.com.server.domain.instrument.dto.InstrumentCreate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "instruments")
@Entity(name = "Instrument")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrument {
	
	public Instrument(@Valid InstrumentCreate data) {
		this.instrument = data.instrument();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String instrument;
}
