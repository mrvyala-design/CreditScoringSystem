package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double salary;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
