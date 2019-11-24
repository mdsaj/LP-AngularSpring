package com.example.AngularSpring.Topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fclass {

@RequestMapping("/start")
	public String start() {
		return "Starting Spring";
	}

}
