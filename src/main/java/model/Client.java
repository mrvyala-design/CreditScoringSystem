package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Employment> employments;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CreditApplication> applications;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private CreditHistory creditHistory;
}
