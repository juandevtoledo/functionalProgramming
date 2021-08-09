package monad.optional;

import monad.optional.dto.Order;

public interface OrderService {

     Order findOrderByOrderId(String orderId);
}
