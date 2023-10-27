package mk.ukim.finki.wp.lab1_nova.web;

import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmationInfoServlet", value = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BalloonService balloonService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("ipAddress", request.getRemoteAddr());
        context.setVariable("os", request.getHeader("User-Agent"));
        context.setVariable("clientName", request.getParameter("clientName"));
        context.setVariable("clientAddress", request.getParameter("clientAddress"));

        this.springTemplateEngine.process("confirmationInfo.html", context, response.getWriter());
    }
}
