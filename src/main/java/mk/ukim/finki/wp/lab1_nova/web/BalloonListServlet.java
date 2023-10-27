package mk.ukim.finki.wp.lab1_nova.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;



import java.io.IOException;

@WebServlet(name = "BalloonListServlet", value = "/listBalloons")
public class BalloonListServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final BalloonService balloonService;

    public BalloonListServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("listBallons", this.balloonService.listAll());
        this.springTemplateEngine.process("listBalloons.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

    }
}
