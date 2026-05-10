package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CreditApplication;
import service.CreditScoringService;
import service.CreditScoringServiceImpl;

import java.io.IOException;

public class ApplicationServlet extends HttpServlet {
    private final CreditScoringService service = new CreditScoringServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        Long clientId = Long.parseLong(req.getParameter("clientId"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        int term = Integer.parseInt(req.getParameter("term"));

        CreditApplication result =
                service.applyForCredit(clientId, amount, term);

        req.setAttribute("result", result);

        req.getRequestDispatcher("/result.jsp")
                .forward(req, resp);
    }
}
