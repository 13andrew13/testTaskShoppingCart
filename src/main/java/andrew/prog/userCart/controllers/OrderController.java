package andrew.prog.userCart.controllers;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.services.OrderServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController{
    @Qualifier ("orderServiceImpl")
    @Autowired
    private OrderServcice orderServcice;
    @RequestMapping("/add/product/{id}/{amount}")
    public ModelAndView addProduct(@PathVariable Long id,@PathVariable Long amount, ModelAndView model){
        Order order;
        if (model.getModelMap ().containsAttribute ("order")){
            order = (Order) model.getModel().get ("order");
        }else {
            order = new Order();
        }
        order = orderServcice.addProductToOrder(order,id,amount);
        return model;
    }

}
