package mk.ukim.finki.wp.lab1_nova.web;

import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "SelectBalloonServlet", value = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final BalloonService balloonService;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("selectBalloon", this.balloonService.listAll());
        this.springTemplateEngine.process("selectBalloonSize.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("balloonColor", color);
        request.getSession().setAttribute("balloonColor", color);
        this.springTemplateEngine.process("selectBalloonSize.html",context,response.getWriter());
    }
}
