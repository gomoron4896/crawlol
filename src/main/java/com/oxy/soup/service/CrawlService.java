package com.oxy.soup.service;

import java.io.IOException;
import java.util.List;

import com.oxy.soup.collection.NaverItNews;

public interface CrawlService {
	
	public List<NaverItNews> getNaverITList() throws IOException;

}
