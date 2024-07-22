package com.pms.repository;
/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.OrderLineItems;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems,Long >{

}
