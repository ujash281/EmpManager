package com.empmng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "index";
	}
}
