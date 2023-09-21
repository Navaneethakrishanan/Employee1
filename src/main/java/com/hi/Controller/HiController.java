package com.hi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	@GetMapping(value="/hi")
	public String getsaved() {
		return "hello world";
	}
	@GetMapping(value="addition/{a}/{b}")
	public String getadd(@PathVariable int a,@PathVariable int b) {
		return "addition of two values";
	}
	

}
