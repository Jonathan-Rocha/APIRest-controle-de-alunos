package br.com.server.domain.format.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.user.User;

public record ClassFormatData(
		Long id,
		String modality,
		Integer timeMinutes,
		Integer price,
		User user
) {
	public ClassFormatData(ClassFormat format) {
		this(
				format.getId(), 
				format.getModality(), 
				format.getTimeMinutes(), 
				format.getPrice(),
				format.getUser()
		);
	}

}
