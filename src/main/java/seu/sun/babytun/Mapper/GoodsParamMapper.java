package seu.sun.babytun.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import seu.sun.babytun.Model.GoodsParam;

public interface GoodsParamMapper {
    int deleteByPrimaryKey(Integer gpId);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Integer gpId);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);

    List<GoodsParam> selectAllByGoodsId(@Param("goodsId")Integer goodsId);


}