package seu.sun.babytun.Mapper;

import seu.sun.babytun.Model.GoodsCover;

import java.util.List;

public interface GoodsCoverMapper {
    int deleteByPrimaryKey(Integer gcId);

    int insert(GoodsCover record);

    int insertSelective(GoodsCover record);

    GoodsCover selectByPrimaryKey(Integer gcId);

    List<GoodsCover> selectBygid(Integer gId);

    int updateByPrimaryKeySelective(GoodsCover record);

    int updateByPrimaryKey(GoodsCover record);
}