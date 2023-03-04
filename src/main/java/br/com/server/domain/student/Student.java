package br.com.server.domain.student;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;

@Table(name = "students")
@Entity(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "days_of_week")
    private DayOfWeek daysOfWeek;

    @ManyToOne(fetch = FetchType.LAZY)
    private Instrument instrument;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClassFormat classFormat;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
