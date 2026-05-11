package dto;

import lombok.Getter;
import lombok.Setter;
import model.enums.ApplicationStatus;

@Setter
@Getter
public class CreditDecisionDTO {

    private Long applicationId;

    private int amount;

    private int termMonths;

    private int score;

    private ApplicationStatus status;
}
