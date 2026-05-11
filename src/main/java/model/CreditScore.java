package model;

import jakarta.persistence.*;
import lombok.*;
import model.enums.ApplicationStatus;

@Entity
@Table(name = "credit_scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @OneToOne
    @JoinColumn(name = "application_id", unique = true)
    private CreditApplication application;
}