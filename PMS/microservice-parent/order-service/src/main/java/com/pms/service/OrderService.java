package com.pms.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.pms.dto.InventoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.dto.OrderLineItemsDto;
import com.pms.dto.OrderRequest;
import com.pms.entity.Order;
import com.pms.entity.OrderLineItems;
import com.pms.repository.OrderRepository;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
@Service
@Transactional
@Slf4j
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient.Builder webClientBuilder;

	public void placeOrder(OrderRequest request) {
		Order order = new Order();

		List<OrderLineItems> orderLineItems = request.getOrderLineItemsDtoList()
				.stream()
				.map(this::mapToDto)
				.toList();

			  	order.setOrderLineItemsList(orderLineItems);

		List<String> skuCodes = order.getOrderLineItemsList().stream()
				.map(OrderLineItems::getSkuCode)
				.toList();


		// Call to inventory-service to place the order if the stock is available,
		var result = webClientBuilder.build().get()
				.uri("http://inventory-service/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		boolean allProductsInStock = Arrays.stream(result)
				.allMatch(InventoryResponse::isInStock);


		if (allProductsInStock){
			orderRepository.save(order);
		}else {
			throw new IllegalArgumentException("Product out of stock, Please try again!,");
		}
		log.info("Placing order");
    }
	
	
	private OrderLineItems mapToDto(OrderLineItemsDto request) {
		OrderLineItems orderLineItems = new OrderLineItems();
						orderLineItems.setOltId(request.getOltId());
						orderLineItems.setPrice(request.getPrice());
						orderLineItems.setQuantity(request.getQuantity());
						orderLineItems.setSkuCode(request.getSkuCode());
		return orderLineItems;
	}
}
