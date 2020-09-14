package seu.sun.babytun.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Model.PromotionSeckill;
import seu.sun.babytun.Mapper.PromotionSeckillMapper;

import java.util.List;

@Service
public class PromotionSeckillService{

    @Resource
    private PromotionSeckillMapper promotionSeckillMapper;

    
    public int deleteByPrimaryKey(Long psId) {
        return promotionSeckillMapper.deleteByPrimaryKey(psId);
    }

    
    public int insert(PromotionSeckill record) {
        return promotionSeckillMapper.insert(record);
    }

    
    public int insertSelective(PromotionSeckill record) {
        return promotionSeckillMapper.insertSelective(record);
    }

    
    public PromotionSeckill selectByPrimaryKey(Long psId) {
        return promotionSeckillMapper.selectByPrimaryKey(psId);
    }

    
    public int updateByPrimaryKeySelective(PromotionSeckill record) {
        return promotionSeckillMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PromotionSeckill record) {
        return promotionSeckillMapper.updateByPrimaryKey(record);
    }

    public List<PromotionSeckill> findunstart(){return promotionSeckillMapper.findAllByStatus();}

    public List<PromotionSeckill> findend(){return promotionSeckillMapper.findAllByStatusEnd();}

}
