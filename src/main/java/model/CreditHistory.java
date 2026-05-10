package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_histories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active_loans")
    private Integer activeLoans;

    @Column(name = "overdue_count")
    private Integer overdueCount;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}