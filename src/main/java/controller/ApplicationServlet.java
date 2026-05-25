package controller;

import dto.CreditDecisionDTO;
import exceptions.ClientNotFoundException;
import exceptions.InvalidCreditAmountException;
import exceptions.InvalidCreditTermException;
import exceptions.ScoringCalculationException;
import lombok.extern.slf4j.Slf4j;
import service.CreditScoringService;
import service.CreditScoringServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ApplicationServlet extends HttpServlet {
    private final CreditScoringService service = new CreditScoringServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        try {
            Long clientId = Long.parseLong(req.getParameter("clientId"));
            int amount = Integer.parseInt(req.getParameter("amount"));
            int term = Integer.parseInt(req.getParameter("term"));

            log.info("New credit application: client id = {}, amount = {}, term = {}", clientId, amount, term);

            CreditDecisionDTO result =
                    service.applyForCredit(clientId, amount, term);

            req.setAttribute("result", result);

            log.info("Application processed successfully for client id = {}", clientId);

            req.getRequestDispatcher("/result.jsp")
                    .forward(req, resp);

        } catch (InvalidCreditAmountException | InvalidCreditTermException | ScoringCalculationException |
                 ClientNotFoundException e) {
            log.warn(e.getMessage());
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Unexpected error", e);
            req.setAttribute("error", "Unexpected error");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}