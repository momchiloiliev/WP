package mk.ukim.finki.wp.lab1_nova.web.controller;

import mk.ukim.finki.wp.lab1_nova.model.Balloon;
import mk.ukim.finki.wp.lab1_nova.model.Manufacturer;
import mk.ukim.finki.wp.lab1_nova.model.Order;
import mk.ukim.finki.wp.lab1_nova.service.BalloonService;
import mk.ukim.finki.wp.lab1_nova.service.ManufacturerService;
import mk.ukim.finki.wp.lab1_nova.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }
    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Balloon> balloons = this.balloonService.listAll();
        model.addAttribute("balloons",balloons);
        return "listBalloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        if (this.balloonService.findById(id).isPresent()) {
            Balloon balloon = this.balloonService.findById(id).get();
            model.addAttribute("manufacturers", this.manufacturerService.findAll());
            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonWithThisIdNotFound";
    }

    @PostMapping("/save")
    public String saveBalloonForNextPage(@RequestParam Long id, HttpServletRequest req) {
        Balloon b = null;
        if(this.balloonService.findById(id).isPresent())
            b = this.balloonService.findById(id).get();
        req.getSession().setAttribute("balloon", b);
        return "selectBalloonSize";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model) {
        model.addAttribute("manufacturers", this.manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam("name") String name, @RequestParam(value = "desc",required = false) String description,@RequestParam Long manufacturerId) {
        this.balloonService.saveBalloon(name, description, manufacturerId);
        return "redirect:/balloons";
    }

    @PostMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/orders")
    public String showOrders(HttpServletRequest request, Model model) {
        String name = request.getParameter("clientName");
        String address = request.getParameter("clientAddress");
        List<Order> orders = this.orderService.searchByClient(name, address);
        model.addAttribute("orders", orders);
        return "userOrders";
    }

}
