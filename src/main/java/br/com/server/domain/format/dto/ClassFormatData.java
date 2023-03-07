package br.com.server.domain.format.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record ClassFormatData(
		Long id,
		String modality,
		Integer timeMinutes,
		Integer price,
		@JsonIgnoreProperties(value = {"enabled", "username", "authorities", "accountNonExpired", "credentialsNonExpired", "accountNonLocked", "hibernateLazyInitializer"})
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
