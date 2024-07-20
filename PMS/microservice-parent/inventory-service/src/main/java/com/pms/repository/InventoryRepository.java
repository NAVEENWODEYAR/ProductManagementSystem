package com.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.Inventory;

/**
 * @author Naveen K Wodeyar
 * @date19-Jul-2024
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySkuCode(String skuCode);
	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
