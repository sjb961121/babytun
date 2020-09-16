package seu.sun.babytun.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import seu.sun.babytun.Exception.SecKillException;
import seu.sun.babytun.Mapper.PromotionSeckillMapper;
import seu.sun.babytun.Model.Order;
import seu.sun.babytun.Model.PromotionSeckill;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SecKillService {
    @Autowired
    private PromotionSeckillMapper promotionSeckillMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void seckill(Long psId,String userId,Integer num) throws SecKillException {
        PromotionSeckill promotionSeckill = promotionSeckillMapper.selectByPrimaryKey(psId);
        if (promotionSeckill==null){
            throw new SecKillException("秒杀活动不存在");
        }
        if (promotionSeckill.getStatus()==0){
            throw new SecKillException("秒杀活动未开始");
        }
        else if (promotionSeckill.getStatus()==2){
            throw new SecKillException("秒杀活动已结束");
        }
        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill:count" + promotionSeckill.getPsId());
        if (goodsId!=null){
            Boolean isExist = redisTemplate.opsForSet().isMember("seckill:user" + promotionSeckill.getPsId(), userId);
            if (!isExist){
                redisTemplate.opsForSet().add("seckill:user"+promotionSeckill.getPsId(),userId);
                System.out.println("下单成功");
            }
            else {
                redisTemplate.opsForList().rightPush("seckill:count" + promotionSeckill.getPsId(),promotionSeckill.getGoodsId());
                throw new SecKillException("抱歉，您已参加过此活动，请勿重复购买");
            }
        }
        else{
            throw new SecKillException("商品已被抢光");
        }
    }

    public String sendOrdertoQueue(String userId){
        System.out.println("向队列发送消息");
        Map data=new HashMap();
        data.put("userId",userId);
        String orderNo= UUID.randomUUID().toString();
        data.put("orderNo",orderNo);
        rabbitTemplate.convertAndSend("exchange-order",null,data);
        return orderNo;
    }


}
