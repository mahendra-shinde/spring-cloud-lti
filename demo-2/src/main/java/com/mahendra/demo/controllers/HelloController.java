package com.mahendra.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping
	public String sayHello(Model map) {
		map.addAttribute("user", "mahendra");
		List<String> months
			= Arrays.asList(new String[]{"Jan","Feb","Mar","Apr",
				"May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
		map.addAttribute("months",months);
		return "hello";
	}
}
