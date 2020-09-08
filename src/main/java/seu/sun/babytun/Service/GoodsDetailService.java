package seu.sun.babytun.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Model.GoodsDetail;
import seu.sun.babytun.Mapper.GoodsDetailMapper;

import java.util.List;

@Service
public class GoodsDetailService{

    @Resource
    private GoodsDetailMapper goodsDetailMapper;

    
    public int deleteByPrimaryKey(Integer gdId) {
        return goodsDetailMapper.deleteByPrimaryKey(gdId);
    }

    
    public int insert(GoodsDetail record) {
        return goodsDetailMapper.insert(record);
    }

    
    public int insertSelective(GoodsDetail record) {
        return goodsDetailMapper.insertSelective(record);
    }

    
    public GoodsDetail selectByPrimaryKey(Integer gdId) {
        return goodsDetailMapper.selectByPrimaryKey(gdId);
    }

    
    public int updateByPrimaryKeySelective(GoodsDetail record) {
        return goodsDetailMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(GoodsDetail record) {
        return goodsDetailMapper.updateByPrimaryKey(record);
    }

    @Cacheable(value = "details",key = "#gId")
    public List<GoodsDetail> selectBygoodsId(Integer gId){ return goodsDetailMapper.selectAllByGoodsId(gId);}

}
