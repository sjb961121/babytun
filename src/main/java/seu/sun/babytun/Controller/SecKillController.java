package seu.sun.babytun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import seu.sun.babytun.Exception.SecKillException;
import seu.sun.babytun.Model.Order;
import seu.sun.babytun.Service.OrderService;
import seu.sun.babytun.Service.SecKillService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {
    @Autowired
    private SecKillService secKillService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/seckill")
    @ResponseBody
    public Map secKill(@RequestParam(value = "psId") Long psId, @RequestParam(value = "userId") String userId){
        Map result=new HashMap();
        try {
            secKillService.seckill(psId,userId,1);
            String orderNo = secKillService.sendOrdertoQueue(userId);
            Map data=new HashMap();
            data.put("orderNo",orderNo);
            result.put("code","0");
            result.put("message","success");
            result.put("data",data);
        } catch (SecKillException e) {
            result.put("code","500");
            result.put("message",e.getMessage());
        }
        return result;
    }

    @GetMapping("/checkorder")
    public ModelAndView checkorder(@RequestParam(value = "orderNo") String orderNo){
        ModelAndView modelAndView=new ModelAndView();
        Order order = orderService.findByOrderNo(orderNo);
        if (order!=null){
            modelAndView.addObject("order",order);
            modelAndView.setViewName("/order");
        }else {
            modelAndView.addObject("orderNo",orderNo);
            modelAndView.setViewName("/waiting");
        }
        return modelAndView;
    }
}
