package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.Order;

/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
