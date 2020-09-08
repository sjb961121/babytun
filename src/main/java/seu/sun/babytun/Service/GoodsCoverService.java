package seu.sun.babytun.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Mapper.GoodsCoverMapper;
import seu.sun.babytun.Model.GoodsCover;

import java.util.List;

@Service
public class GoodsCoverService{

    @Resource
    private GoodsCoverMapper goodsCoverMapper;

    
    public int deleteByPrimaryKey(Integer gcId) {
        return goodsCoverMapper.deleteByPrimaryKey(gcId);
    }

    
    public int insert(GoodsCover record) {
        return goodsCoverMapper.insert(record);
    }

    
    public int insertSelective(GoodsCover record) {
        return goodsCoverMapper.insertSelective(record);
    }

    
    public GoodsCover selectByPrimaryKey(Integer gcId) {
        return goodsCoverMapper.selectByPrimaryKey(gcId);
    }

    @Cacheable(value = "covers",key = "#gId")
    public List<GoodsCover> selectBygid(Integer gId) {
        return goodsCoverMapper.selectBygid(gId);
    }

    public int updateByPrimaryKeySelective(GoodsCover record) {
        return goodsCoverMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(GoodsCover record) {
        return goodsCoverMapper.updateByPrimaryKey(record);
    }

}
