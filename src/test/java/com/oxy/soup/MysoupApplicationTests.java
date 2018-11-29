package com.oxy.soup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oxy.soup.collection.NaverItNews;
import com.oxy.soup.repository.NaverItNewsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysoupApplicationTests {
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MysoupApplicationTests.class);
	
	@Value("${ex.target.uri}")
	private String connect_uri;
	
	@Value("${ex.ftParent.selector}")
	private String parentQuery;
	
	@Value("${ex.ftCategory.selector}")
	private String categoryQuery;
	
	@Value("${ex.ftDetails.selector}")
	private String detailsQuery;
	
/*	static {
		connect_uri = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=230";
		select_query = "ul.type06_headline";
	}*/
	
	@Autowired
	private NaverItNewsRepository nnr;

	@Test
	public void contextLoads() throws IOException {
		List<NaverItNews> rList = new ArrayList<NaverItNews>();
		
		Document doc = Jsoup.connect(connect_uri).get();
		Elements parents = doc.select(parentQuery);
		
		for(Element child : parents) {
			NaverItNews collection = new NaverItNews();
			List<Map<String, String>> ranking = new ArrayList<Map<String, String>>();
			
			DateTime nowDate = new DateTime();
			DateTimeFormatter tForm = DateTimeFormat.forPattern("yyyy-MM-dd_HH:mm:ss.SSS");
			
			for(Element details : child.select(detailsQuery)) {
				Map<String, String> rankMap = new HashMap<String, String>();
				rankMap.put("rank", details.select("em").text().replace("위", ""));
				rankMap.put("keyWord", details.select(".link_txt").text());
				ranking.add(rankMap);
			}
			
			collection.setAid(tForm.print(nowDate)+"ran"+(Math.random()+"").replace(".", ""));
			collection.setCategory(child.select(categoryQuery).html());
			collection.setRanking(ranking);
			rList.add(collection);
			log.info(tForm.print(nowDate));
		}
		
		log.info(rList.toString());
		
	}
}
