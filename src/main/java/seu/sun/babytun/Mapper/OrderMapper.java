package seu.sun.babytun.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import seu.sun.babytun.Model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order findByOrderNo(@Param("orderNo")String orderNo);


}