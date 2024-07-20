package com.pms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pms.entity.Inventory;
import com.pms.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
		System.out.println("inventory\nservicE");
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args->{
			Inventory inventory = new Inventory();
					  inventory.setSkuCode("Iphone 16");
					  inventory.setQuantity(10);
		    Inventory inventory1 = new Inventory();
					  inventory1.setSkuCode("Iphone 16Plus");
					  inventory1.setQuantity(20);

			Inventory inventory2 = new Inventory();
					  inventory2.setSkuCode("Iphone 16Pro");
					  inventory2.setQuantity(30);
			Inventory inventory3 = new Inventory();
					  inventory3.setSkuCode("Iphone 16ProMax");
					  inventory3.setQuantity(40);

					  inventoryRepository.save(inventory);
					  inventoryRepository.save(inventory1);
					  inventoryRepository.save(inventory2);
					  inventoryRepository.save(inventory3);
		};
	}

}
