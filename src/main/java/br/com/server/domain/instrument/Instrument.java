package br.com.server.domain.instrument;

import br.com.server.domain.instrument.dto.InstrumentCreate;
import br.com.server.domain.instrument.dto.InstrumentUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "instruments")
@Entity(name = "Instrument")
@Getter
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

    public void update(@Valid InstrumentUpdate data) {
		if (data.instrument() != null) {
			this.instrument = data.instrument();
		}
    }
}
