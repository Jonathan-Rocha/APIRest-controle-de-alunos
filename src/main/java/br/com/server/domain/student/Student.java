package br.com.server.domain.student;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.student.dto.StudentUpdate;
import br.com.server.domain.student.dto.StudentCreate;
import br.com.server.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "students")
@Entity(name = "Students")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {

    public Student(@Valid StudentCreate data) {
        this.name = data.name();
        this.instrument = data.instrument();
        this.classFormat = data.classFormat();
        this.user = data.user();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Instrument instrument;

    @ManyToOne
    private ClassFormat classFormat;

    @ManyToOne
    private User user;

    public void update(@Valid StudentUpdate data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.instrument() != null) {
            this.instrument = data.instrument();
        }
        if (data.classFormat() != null) {
            this.classFormat = data.classFormat();
        }
        if (data.user() != null) {
            this.user = data.user();
        }
    }
}
