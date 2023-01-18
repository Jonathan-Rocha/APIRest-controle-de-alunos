package br.com.server.domain.format;

import java.math.BigDecimal;

import br.com.server.domain.format.dto.ClassFormatCreate;
import br.com.server.domain.format.dto.ClassFormatUpdate;
import jakarta.persistence.Column;
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

@Table(name = "class_formats")
@Entity(name = "ClassFormat")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClassFormat {

	public ClassFormat(@Valid ClassFormatCreate data) {
		this.modality = data.modality();
		this.timeMinutes = data.timeMinutes();
		this.price = data.price();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modality;
	
	@Column(name = "time_minutes")
	private String timeMinutes;
	private BigDecimal price;

	public void update(@Valid ClassFormatUpdate data) {
		if(data.modality() != null) {
			this.modality = data.modality();
		}
		if(data.timeMinutes() != null) {
			this.timeMinutes = data.timeMinutes();
		}
		if(data.price() != null) {
			this.price = data.price();
		}
	}
}
