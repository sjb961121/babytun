package seu.sun.babytun.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import seu.sun.babytun.Model.PromotionSeckill;

public interface PromotionSeckillMapper {
    int deleteByPrimaryKey(Long psId);

    int insert(PromotionSeckill record);

    int insertSelective(PromotionSeckill record);

    PromotionSeckill selectByPrimaryKey(Long psId);

    int updateByPrimaryKeySelective(PromotionSeckill record);

    int updateByPrimaryKey(PromotionSeckill record);

    List<PromotionSeckill> findAllByStatus();

    List<PromotionSeckill> findAllByStatusEnd();

}