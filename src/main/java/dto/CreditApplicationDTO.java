package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditApplicationDTO {

    private Long clientId;

    private int amount;

    private int termMonths;
}
