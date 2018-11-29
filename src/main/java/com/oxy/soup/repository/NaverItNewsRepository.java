package com.oxy.soup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.oxy.soup.collection.NaverItNews;

public interface NaverItNewsRepository extends MongoRepository<NaverItNews, String> {
	
	@Query("{aid:?0}")
	public List<NaverItNews> findByAId(String aid);
}
