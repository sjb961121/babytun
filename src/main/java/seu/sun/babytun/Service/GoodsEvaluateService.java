package seu.sun.babytun.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Mapper.GoodsEvaluateMapper;
import seu.sun.babytun.Model.GoodsEvaluate;

import java.util.List;

@Service
public class GoodsEvaluateService{

    @Resource
    private GoodsEvaluateMapper goodsEvaluateMapper;

    
    public int deleteByPrimaryKey(Long evaluateId) {
        return goodsEvaluateMapper.deleteByPrimaryKey(evaluateId);
    }

    
    public int insert(GoodsEvaluate record) {
        return goodsEvaluateMapper.insert(record);
    }

    
    public int insertSelective(GoodsEvaluate record) {
        return goodsEvaluateMapper.insertSelective(record);
    }

    
    public GoodsEvaluate selectByPrimaryKey(Long evaluateId) {
        return goodsEvaluateMapper.selectByPrimaryKey(evaluateId);
    }

    
    public int updateByPrimaryKeySelective(GoodsEvaluate record) {
        return goodsEvaluateMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(GoodsEvaluate record) {
        return goodsEvaluateMapper.updateByPrimaryKey(record);
    }

    public List<GoodsEvaluate> findEvaluates(Long gId){return goodsEvaluateMapper.selectAllByGoodsIdOrderByCreateTimeDesc(gId);}
}
