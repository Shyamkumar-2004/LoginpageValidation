package com.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.Entity1.Entity1;

import com.foodapp.service.serviceclass;
import com.foodapp.service1.Service1;

@RestController
public class controllerclass {

	@Autowired
	serviceclass service;
	@Autowired
	Service1 ser;

	@PostMapping("/savelogindata")
	public Entity1 savelogindata(@RequestBody Entity1 login) {

		return ser.savelogin_data(login);

	}

	@GetMapping("/getlogin_data")
	public List<Entity1> getlogindata() {
		return ser.getlogin_data();
	}

	@GetMapping("/getlogindata/{id}")
	public String getdata(@PathVariable int id, @RequestParam String name, @RequestParam String password) {
		Entity1 entity = ser.getdataby_id(id);

		if (entity != null) {
			System.out.println("Retrieved Name: " + entity.getUser_name());
			System.out.println("Retrieved Password: " + entity.getUser_password());

			if (entity.getUser_name().equals(name) && entity.getUser_password().equals(password)) {
				return "success";
			} else {
				return "error(data does not match)";
			}
		} else {
			System.out.println("Entity not found for id: " + id);
			return "error(data not found)";
		}
	}

}
