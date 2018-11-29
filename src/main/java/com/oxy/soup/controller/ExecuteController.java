package com.oxy.soup.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxy.soup.collection.NaverItNews;
import com.oxy.soup.service.CrawlService;

@Controller
public class ExecuteController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExecuteController.class);

	@Autowired
	private CrawlService cs;
	
	@PostMapping(value="/execute")
	@ResponseBody
	public List<NaverItNews> postMethodName(@RequestBody Map<String, String> auth) throws Exception {
		log.info("계정 인증 : " + auth.toString());
		
		if(!("test".equals(auth.get("id")))) {
			throw new Exception("WRONG ID");
		}
		
		if(!("test".equals(auth.get("pwd")))) {
			throw new Exception("WRONG PWD");
		}
		log.info("HI");
		return cs.getNaverITList();
	}
	
}
