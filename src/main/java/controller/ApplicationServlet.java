package controller;

import dto.CreditDecisionDTO;
import model.CreditApplication;
import service.CreditScoringService;
import service.CreditScoringServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {
    private final CreditScoringService service = new CreditScoringServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        Long clientId = Long.parseLong(req.getParameter("clientId"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        int term = Integer.parseInt(req.getParameter("term"));

        CreditDecisionDTO result =
                service.applyForCredit(clientId, amount, term);

        req.setAttribute("result", result);

        req.getRequestDispatcher("/result.jsp")
                .forward(req, resp);
    }
}
