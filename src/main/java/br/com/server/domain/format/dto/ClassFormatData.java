package br.com.server.domain.format.dto;

import java.math.BigDecimal;

import br.com.server.domain.format.ClassFormat;

public record ClassFormatData(
		Long id,
		String modality,
		String timeMinutes,
		BigDecimal price
		) {

	public ClassFormatData(ClassFormat format) {
		this(
				format.getId(), 
				format.getModality(), 
				format.getTimeMinutes(), 
				format.getPrice()
			);
	}

}
