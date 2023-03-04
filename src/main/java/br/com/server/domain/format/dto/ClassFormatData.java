package br.com.server.domain.format.dto;

import br.com.server.domain.format.ClassFormat;

public record ClassFormatData(
		Long id,
		String modality,
		Integer timeMinutes,
		Integer price,
		Long userId
) {
	public ClassFormatData(ClassFormat format) {
		this(
				format.getId(), 
				format.getModality(), 
				format.getTimeMinutes(), 
				format.getPrice(),
				format.getUser().getId()
		);
	}

}
