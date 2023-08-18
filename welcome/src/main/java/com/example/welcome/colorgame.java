package com.example.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class colorgame {
	@RequestMapping("/color")
	@ResponseBody
	public String getMyFav()
	{
		String yourFavColor="Lavender";
		return "My Favorite colour is "+yourFavColor;
	}
}
