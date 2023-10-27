package mk.ukim.finki.wp.lab1_nova.web;

import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import mk.ukim.finki.wp.lab1_nova.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BalloonOrderServlet", value = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final BalloonService balloonService;
    public final OrderService orderService;


    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService, BalloonService balloonService, OrderService orderService1) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
        this.orderService = orderService;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebContext context = new WebContext(request,response,request.getServletContext());
        springTemplateEngine.process("deliveryInfo.html",context,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        WebContext context = new WebContext(request, response, request.getServletContext());
        request.getSession().setAttribute("balloonSize", size);
        context.setVariable("balloonColor", color);
        context.setVariable("balloonSize", size);
        this.springTemplateEngine.process("deliveryInfo.html", context, response.getWriter());
    }
}
