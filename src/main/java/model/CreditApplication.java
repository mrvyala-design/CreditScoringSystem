package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @Column(name = "term_months")
    private Integer termMonths;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
    private CreditScore creditScore;
}