package com.pms.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dto.OrderLineItemsDto;
import com.pms.dto.OrderRequest;
import com.pms.entity.Order;
import com.pms.entity.OrderLineItems;
import com.pms.repository.OrderRepository;

/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderRequest request) {
		Order order = new Order();
			  order.setONumber(UUID.randomUUID().toString());
			  	List<OrderLineItems> list = request.getOrderLineItemsDtos()
			  			.stream()
			  			.map(this::maptToDto)
			  			.toList();
			  			
			  	order.setOLineItemList(list);	
			  	orderRepository.save(order);
	}
	
	
	private OrderLineItems maptToDto(OrderLineItemsDto request) {
		OrderLineItems orderLineItems = new OrderLineItems();
						orderLineItems.setOltId(request.getOltId());
						orderLineItems.setPrice(request.getPrice());
						orderLineItems.setQuantity(request.getQuantity());
						orderLineItems.setSkuCode(request.getSkuCode());
		return orderLineItems;
	}
}
