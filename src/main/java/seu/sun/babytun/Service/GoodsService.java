package seu.sun.babytun.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import seu.sun.babytun.Mapper.GoodsMapper;
import seu.sun.babytun.Model.GoodsExample;
import seu.sun.babytun.Model.Goods;
@Service
public class GoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    
    public long countByExample(GoodsExample example) {
        return goodsMapper.countByExample(example);
    }

    
    public int deleteByExample(GoodsExample example) {
        return goodsMapper.deleteByExample(example);
    }

    
    public int deleteByPrimaryKey(Integer goodsId) {
        return goodsMapper.deleteByPrimaryKey(goodsId);
    }

    
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    
    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }

    
    public List<Goods> selectByExample(GoodsExample example) {
        return goodsMapper.selectByExample(example);
    }

    @Cacheable(value = "goods",key = "#goodsId")
    public Goods selectByPrimaryKey(Integer goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    public List<Goods> selectAll(){return goodsMapper.selectAll();}

    public int updateByExampleSelective(Goods record,GoodsExample example) {
        return goodsMapper.updateByExampleSelective(record,example);
    }

    
    public int updateByExample(Goods record,GoodsExample example) {
        return goodsMapper.updateByExample(record,example);
    }

    
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    public List<Goods> selectLastUpdateTime(){return goodsMapper.selectAllByLastUpdateTime();}

}
