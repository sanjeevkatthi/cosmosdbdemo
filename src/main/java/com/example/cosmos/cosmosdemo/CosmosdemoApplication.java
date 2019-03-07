package com.example.cosmos.cosmosdemo;

import com.example.cosmos.cosmosdemo.dao.ItemDetailsDao;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CosmosdemoApplication implements CommandLineRunner {

	@Autowired
	private ItemDetailsDao itemDetailsDao;

	public static void main(String[] args) {
		SpringApplication.run(CosmosdemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		itemDetailsDao.deleteById(6);

//		ItemDetails itemDetail2 = new ItemDetails(2,"iphone 9 mobile","iphone 9 mobile");
//		ItemDetails itemDetail3 = new ItemDetails(3,"oneplux x","oneplux x");
//		ItemDetails itemDetail4 = new ItemDetails(4,"Samsung G8","Samsung G8");
//		ItemDetails itemDetail5 = new ItemDetails(5,"Mi Note 3","Mi Note 3");
//		ItemDetails itemDetail6 = new ItemDetails(6,"Pixel 3","Pixel 3");
//		ItemDetails itemDetail7 = new ItemDetails(7,"Pico F1","Pico F1");
//		List<ItemDetails> itemDetailsList =Stream.of(itemDetail2,itemDetail3,itemDetail4,itemDetail5,itemDetail6,itemDetail7).collect(Collectors.toList());
//		itemDetailsDao.saveAll(itemDetailsList);

//		ItemDetails savedItem = itemDetailsDao.save(itemDetail);

//		System.out.println("saved.. "+ savedItem);

//		Optional<ItemDetails> itemDetails = itemDetailsDao.findById(5);
//		itemDetails.ifPresent(item->
//				{
//						System.out.println("item Deails: "+ item);
//				}
//		);

		List<ItemDetails> list =itemDetailsDao.findAll();
		list.stream().forEach(System.out::println);


	}
}
