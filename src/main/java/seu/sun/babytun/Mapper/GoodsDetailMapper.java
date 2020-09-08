package seu.sun.babytun.Mapper;

import seu.sun.babytun.Model.GoodsDetail;

import java.util.List;

public interface GoodsDetailMapper {
    int deleteByPrimaryKey(Integer gdId);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Integer gdId);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);

    List<GoodsDetail> selectAllByGoodsId(Integer gId);
}