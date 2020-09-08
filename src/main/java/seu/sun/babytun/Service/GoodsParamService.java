package seu.sun.babytun.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Model.GoodsParam;
import seu.sun.babytun.Mapper.GoodsParamMapper;

import java.util.List;

@Service
public class GoodsParamService{

    @Resource
    private GoodsParamMapper goodsParamMapper;

    
    public int deleteByPrimaryKey(Integer gpId) {
        return goodsParamMapper.deleteByPrimaryKey(gpId);
    }

    
    public int insert(GoodsParam record) {
        return goodsParamMapper.insert(record);
    }

    
    public int insertSelective(GoodsParam record) {
        return goodsParamMapper.insertSelective(record);
    }

    
    public GoodsParam selectByPrimaryKey(Integer gpId) {
        return goodsParamMapper.selectByPrimaryKey(gpId);
    }

    
    public int updateByPrimaryKeySelective(GoodsParam record) {
        return goodsParamMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(GoodsParam record) {
        return goodsParamMapper.updateByPrimaryKey(record);
    }

    @Cacheable(value = "params",key = "#gId")
    public List<GoodsParam> selectBygoodsId(Integer gId){return goodsParamMapper.selectAllByGoodsId(gId);}

}
