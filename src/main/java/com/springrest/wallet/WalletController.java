package com.springrest.wallet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.springrest.wallet.resources.CustomerWallet;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RestController
public class WalletController {
	
	//ArrayList<CustomerWallet> wallet = new ArrayList<CustomerWallet>();
	
	HashMap<Integer, Integer> custList = new HashMap<Integer, Integer>();
	
	
	@PostMapping("/addBalance")
	public ResponseEntity<String> addAmount(@RequestBody Map<String, Integer> cust)
	{
		Integer custId = cust.get("custId");
		Integer amount = cust.get("amount"); 
		Integer balance = custList.get(custId);
		custList.put(custId,balance+amount);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@PostMapping("/deductBalance")
	public ResponseEntity<HttpStatus> deductAmount(@RequestBody Map<String, Integer> cust)
	{
		Integer custId = cust.get("custId");
		Integer amount = cust.get("amount"); 
		Integer balance = custList.get(custId);
		
		if(balance>=amount) {
			custList.put(custId,balance-amount);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.GONE);
		}
	}
	
	@GetMapping("/Balance/{custId}")
	public ResponseEntity<Map<String, Integer>> Amount(@PathVariable Integer custId)
	{
		HashMap<String, Integer> map = new HashMap<>();
		map.put("custId", custId);
		map.put("balance", custList.get(custId));
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
	@PostMapping("/reInitialize")
	public ResponseEntity<String> reInitialize() throws FileNotFoundException
	{	
		//File myFile = new File("/Users/fluffy/Downloads/wallet/initialData.txt");
		String basePath = new File("").getAbsolutePath();
		File myFile = new File(basePath + "/initialData.txt");
		Scanner s1 = null;
		try 
		{
			s1 = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Scanner s2 = new Scanner(myFile);
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		String str1 = s2.nextLine();
		Integer bal = Integer.parseInt(str1);
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
			custList.put(Integer.parseInt(str), bal);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");	
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public HttpStatus StartUp() throws FileNotFoundException
	{
		//File myFile = new File("/Users/fluffy/Downloads/wallet/initialData.txt");
		String basePath = new File("Dummy").getAbsolutePath();
		File myFile = new File(basePath + "/initialData.txt");
		Scanner s1 = null;
		try 
		{
			s1 = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Scanner s2 = new Scanner(myFile);
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		String str1 = s2.nextLine();
		Integer bal = Integer.parseInt(str1);
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
			custList.put(Integer.parseInt(str), bal);
		}

		return HttpStatus.CREATED;
	}
	
	@GetMapping("/showData")
	public HashMap<Integer, Integer> showData()
	{
		return custList;
	}
}
