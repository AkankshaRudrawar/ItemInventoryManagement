package com.iteminventorymanagement.example.ItemInventoryManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItembyId(@PathVariable Long id){
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			return new ResponseEntity<>(item.get(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public Item createItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id,@RequestBody Item item){
		Optional<Item> itemOptional = itemRepository.findById(id);
		if(itemOptional.isPresent()) {
			item.setId(id);
			itemRepository.save(item);
			return new ResponseEntity<>(item,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long id){
		try {
			itemRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> searchItemsByNameOrSku(
	        @RequestParam(value = "name", required = false) String name,
	        @RequestParam(value = "sku", required = false) String sku) {
	    List<Item> items;
	    if (name != null) {
	        items = itemRepository.findByNameContainingIgnoreCase(name);
	    } else if (sku != null) {
	        items = itemRepository.findBySkuContainingIgnoreCase(sku);
	    } else {
	        items = itemRepository.findAll();
	    }
	    if (items.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(items);
	    }
	}
}