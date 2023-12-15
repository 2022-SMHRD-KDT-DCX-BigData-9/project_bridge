package com.smhrd.bridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.bridge.entity.UserInfo;
import com.smhrd.bridge.service.MatchingService;

@Controller
public class MatchingContoller {
	@Autowired
	MatchingService service;

	@GetMapping("/matchingPage") 
	public String matchingPage(Model model, @RequestParam(defaultValue = "1") int page) { 
	int pageSize = 8; 
	// 한 페이지에 표시할 항목 수 
	List<UserInfo> userAll = service.matchingPage(); 
	int totalRecipes = userAll.size(); 
	int totalPages = (int) Math.ceil((double) totalRecipes / pageSize);
	  
	int startIndex = (page - 1) * pageSize; 
	int endIndex = Math.min(startIndex + pageSize, totalRecipes);
	  
	List<UserInfo> userAllList = userAll.subList(startIndex, endIndex);
	  
	model.addAttribute("userAll", userAllList); 
	model.addAttribute("page", page);
	model.addAttribute("totalPages", totalPages);
	  
	return "matchingPage"; }

}
