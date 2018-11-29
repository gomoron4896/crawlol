package com.oxy.soup.collection;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("naverit")
public class NaverItNews {

	private String aid;
	private String category;
	private List<Map<String, String>> ranking;

	public NaverItNews() {
	}

	public NaverItNews(String category, List<Map<String, String>> ranking, String aid) {
		super();
		this.category = category;
		this.ranking = ranking;
		this.aid = aid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Map<String, String>> getRanking() {
		return ranking;
	}

	public void setRanking(List<Map<String, String>> ranking) {
		this.ranking = ranking;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "NaverItNews [aid=" + aid + ", category=" + category + ", ranking=" + ranking + "]";
	}

}
