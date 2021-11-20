package com.AbdulMalikKarimAJmartMR.controller;

import com.AbdulMalikKarimAJmartMR.Account;
import com.AbdulMalikKarimAJmartMR.Algorithm;
import com.AbdulMalikKarimAJmartMR.Store;
import com.AbdulMalikKarimAJmartMR.dbjson.JsonAutowired;
import com.AbdulMalikKarimAJmartMR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!-)[a-zA-Z0-9-]+\\.(?!.*\\.$)[a-zA-Z0-9.]+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](\\S){8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);


	@JsonAutowired(value = Account.class, filepath = "D:\\project\\jmart\\src\\main\\java\\com\\AbdulMalikKarimAJmartMR\\account.json")
	public static JsonTable<Account> accountTable;

	@Override
	public JsonTable<Account> getJsonTable() {
		return accountTable;
	}
	@PostMapping("/login")
	Account login
			(
					@RequestParam String email,
					@RequestParam String password
			)
	{
		return Algorithm.<Account>find(accountTable, obj -> obj.email.equals(email) && obj.password.equals(password));
	}

	@PostMapping("/register")
	Account register
			(
					@RequestParam String name,
					@RequestParam String email,
					@RequestParam String password
			)
	{
		if(name.isBlank()) return null;
		Matcher matcher1 = REGEX_PATTERN_EMAIL.matcher(email);
		if(!matcher1.find()) return null;
		Matcher matcher2 = REGEX_PATTERN_PASSWORD.matcher(password);
		if(!matcher2.find()) return null;
		if(Algorithm.<Account>find(accountTable, obj -> obj.email.equals(email)) != null) return null;
		Account a = new Account(name, email, password, 0);
		accountTable.add(a);
		return a;
	}

	@PostMapping("/{id}/registerStore")
	Store registerStore
			(
					@PathVariable int id,
					@RequestParam String name,
					@RequestParam String address,
					@RequestParam String phoneNumber
			)
	{
		Account acc = Algorithm.<Account>find(accountTable, obj -> obj.id == id);
		if(acc == null || acc.store != null) return null;
		acc.store = new Store(name, address, phoneNumber);
		return acc.store;
	}

	@PostMapping("/{id}/topUp")
	boolean topUp
			(
					@PathVariable int id,
					@RequestParam double balance
			)
	{
		Account acc = Algorithm.<Account>find(accountTable, obj -> obj.id == id);
		if(acc == null) return false;
		acc.balance += balance;
		return true;
	}

}