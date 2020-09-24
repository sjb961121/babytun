package seu.sun.babytun.Service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import seu.sun.babytun.Model.Order;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class OrderConsumer {
    @Autowired
    private OrderService orderService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue("queue-order"),exchange = @Exchange("exchange-order")))
    public void handleMessage(@Payload Map data, Channel channel,@Headers Map<String,Object> headers){
        System.out.println("获取订单数据"+data);
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Order order=new Order();
            order.setOrderNo(data.get("orderNo").toString());
            order.setOrderStatus(0);
            order.setUserid(data.get("userId").toString());
            order.setAmout(19.8d);
            order.setRecvName("sun");
            order.setRecvMobile("133xxxxxx");
            order.setRecvAddress("xxxxxxxx");
            order.setPostage(0.00d);
            order.setCreateTime(new Date());
            orderService.insert(order);
            Long tag=(Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(tag,false);
            System.out.println(data.get("orderNo")+"订单已创建");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
