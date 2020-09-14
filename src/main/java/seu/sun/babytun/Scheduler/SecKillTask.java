package seu.sun.babytun.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import seu.sun.babytun.Model.PromotionSeckill;
import seu.sun.babytun.Service.PromotionSeckillService;

import java.util.List;

@Component
public class SecKillTask {
    @Autowired
    private PromotionSeckillService promotionSeckillService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Scheduled(cron = "0/5 * * * * ?")
    public void startSecKill(){
        List<PromotionSeckill> unstart = promotionSeckillService.findunstart();
        for (PromotionSeckill promotionSeckill:unstart){
            System.out.println(promotionSeckill.getPsId()+"秒杀活动已启动");
            redisTemplate.delete("seckill:count"+promotionSeckill.getPsId());
            for (int i=0;i<promotionSeckill.getPsCount();i++){
                redisTemplate.opsForList().rightPush("seckill:count"+promotionSeckill.getPsId(),promotionSeckill.getGoodsId());
            }
            promotionSeckill.setStatus(1);
            promotionSeckillService.updateByPrimaryKey(promotionSeckill);

        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void endSecKill(){
        List<PromotionSeckill> end = promotionSeckillService.findend();
        for (PromotionSeckill ps:end){
            System.out.println(ps.getPsId()+"秒杀活动已结束");
            ps.setStatus(2);
            promotionSeckillService.updateByPrimaryKey(ps);
            redisTemplate.delete("seckill:count"+ps.getPsId());
        }
    }
}
