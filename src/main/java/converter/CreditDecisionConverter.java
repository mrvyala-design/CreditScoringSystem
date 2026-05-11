package converter;

import dto.CreditDecisionDTO;
import model.CreditApplication;

public class CreditDecisionConverter {

    public CreditDecisionDTO toDTO(CreditApplication creditApplication, int score) {

        CreditDecisionDTO dto = new CreditDecisionDTO();

        dto.setApplicationId(creditApplication.getId());
        dto.setAmount(creditApplication.getAmount());
        dto.setTermMonths(creditApplication.getTermMonths());
        dto.setScore(score);
        dto.setStatus(creditApplication.getStatus());

        return dto;
    }
}