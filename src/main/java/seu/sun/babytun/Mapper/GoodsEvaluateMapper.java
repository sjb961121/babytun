package seu.sun.babytun.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import seu.sun.babytun.Model.GoodsEvaluate;

public interface GoodsEvaluateMapper {
    int deleteByPrimaryKey(Long evaluateId);

    int insert(GoodsEvaluate record);

    int insertSelective(GoodsEvaluate record);

    GoodsEvaluate selectByPrimaryKey(Long evaluateId);

    int updateByPrimaryKeySelective(GoodsEvaluate record);

    int updateByPrimaryKey(GoodsEvaluate record);

    List<GoodsEvaluate> selectAllByGoodsIdOrderByCreateTimeDesc(@Param("goodsId")Long goodsId);


}