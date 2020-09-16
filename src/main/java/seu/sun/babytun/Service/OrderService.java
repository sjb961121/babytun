package seu.sun.babytun.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import seu.sun.babytun.Model.Order;
import seu.sun.babytun.Mapper.OrderMapper;
@Service
public class OrderService{

    @Resource
    private OrderMapper orderMapper;

    
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    public Order findByOrderNo(String orderNo){return orderMapper.findByOrderNo(orderNo);}

}
