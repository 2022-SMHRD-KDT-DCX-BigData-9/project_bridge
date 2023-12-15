package com.smhrd.bridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/preference")
	public String preference() {
		return "preference";
	}

//	@GetMapping("/matchingpage")
//	public String matchingpage() {
//		return "matchingpage";
//	}

//	@GetMapping("/mypage")
//	public String mypage() {
//		return "mypage";
//	}
	
	@GetMapping("/uploadmusic")
	public String uploadmusic() {
		return "uploadmusic";
	}
}
