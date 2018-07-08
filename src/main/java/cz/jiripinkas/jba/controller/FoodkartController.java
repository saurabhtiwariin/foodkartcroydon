package cz.jiripinkas.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodkartController {

	@RequestMapping("/foodkart")
	public String foodkart() {		
		return "foodkart";
	}
	
	@RequestMapping("/fkspecial")
	public String fkspecial() {		
		return "fkspecial";
	}
	
	@RequestMapping("/fkmenu")
	public String fkmenu() {		
		return "fkmenu";
	}

	@RequestMapping("/fkcomingsoon")
	public String fkcomingsoon() {		
		return "fkcomingsoon";
	}

	
	@RequestMapping("/fktakeawaypoint")
	public String fktakeawaypoint() {		
		return "fktakeawaypoint";
	}

}
