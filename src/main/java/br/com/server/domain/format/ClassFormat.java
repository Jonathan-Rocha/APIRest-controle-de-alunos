package br.com.server.domain.format;

import br.com.server.domain.format.dto.ClassFormatUpdate;
import br.com.server.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modality;
	@Column(name = "time_minutes")
	private Integer timeMinutes;
	private Integer price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties(value = {"enabled", "username", "authorities", "accountNonExpired", "credentialsNonExpired", "accountNonLocked", "hibernateLazyInitializer"})
	private User user;

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
