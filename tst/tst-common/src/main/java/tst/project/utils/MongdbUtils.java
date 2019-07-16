package tst.project.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.bson.Document;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongdbUtils {
	public static void main(String args[]) {
		Map<String, Object> result=getEncyclopedia("68707-69-7");
		System.out.println(JSON.toJSONString(result));
	}
	
	public static Map<String, Object> getEncyclopedia(String cas) {
		// TODO Auto-generated method stub
		ServerAddress serverurl = new ServerAddress("47.100.104.246", 27017);
		List<ServerAddress> lists = new ArrayList<ServerAddress>();
		lists.add(serverurl);
		MongoCredential credential = MongoCredential.createCredential("test", "Test", "123456".toCharArray());

		final MongoClientOptions.Builder build = new MongoClientOptions.Builder();
//		build.connectionsPerHost(Integer.valueOf(maxConnect));  
//        build.threadsAllowedToBlockForConnectionMultiplier(Integer.valueOf(maxWaitThread));  
//        build.connectTimeout(Integer.valueOf(maxTimeOut) * 1000);  
//        build.maxWaitTime(Integer.valueOf(maxWaitTime) * 1000);  
		MongoClientOptions options = build.build();
		
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(lists, credential,options);
		
		MongoDatabase mongoDatabase = client.getDatabase("Test");
		MongoCollection<Document> collection = mongoDatabase.getCollection("cn_olbase");
		//MongoCollection<Document> collection = mongoDatabase.getCollection("en_olbase");
		//MongoCollection<Document> collection = mongoDatabase.getCollection("tgsc");
		BasicDBObject query = new BasicDBObject();
//		//模糊查询
//        Pattern pattern = Pattern.compile("^.*王.*$", Pattern.CASE_INSENSITIVE);
//        query.put("userName", pattern);
        //精确查询
        query.put("CAS号", cas);
        
		Map<String, Object> baseMap=new HashMap<String, Object>();
		List<Map<String, Object>> baseBeans=new ArrayList<Map<String, Object>>();

		FindIterable<Document> documents = collection.find(query);
		for (Document document : documents) {
			Document document2=(Document) document.get("elm");
			Document baseDocument1=(Document) document2.get("基本信息");
				       
			baseMap.put("cn_name", baseDocument1.getString("中文名称"));
			baseMap.put("cn_alias", baseDocument1.getString("中文别名"));
			baseMap.put("en_name", baseDocument1.getString("英文名称"));
			baseMap.put("en_alias", baseDocument1.getString("英文别名"));
			baseMap.put("molecular_formula", baseDocument1.getString("分子式"));
			baseMap.put("molecular_weight", baseDocument1.getString("分子量"));
			baseMap.put("exact_mass", baseDocument1.getString("精确质量"));
			
			Document baseDocument2=(Document) document2.get("物化性质");
			Set<String> set2=baseDocument2.keySet();
			for (String str : set2) {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("encyclopedia_key", str);
				map.put("encyclopedia_value", baseDocument2.getString(str));
				map.put("encyclopedia_type", "2");
				baseBeans.add(map);
			}
			
			Document baseDocument3=(Document) document2.get("安全信息");
			Set<String> set3=baseDocument3.keySet();
			
			for (String str : set3) {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("encyclopedia_key", str);
				map.put("encyclopedia_value", baseDocument3.getString(str));
				map.put("encyclopedia_type", "3");
				baseBeans.add(map);
			}
			
			String virulence=document2.getString("毒性");
			String customs=document2.getString("海关数据");
			String msds=document2.getString("MSDS");
			String sds_cn=document2.getString("SDS中文");
			String sds_en=document2.getString("SDS英文");
			baseMap.put("baseBeans", baseBeans);
			baseMap.put("virulence", virulence);
			baseMap.put("customs", customs);
			baseMap.put("msds", msds);
			baseMap.put("sds_cn", sds_cn);
			baseMap.put("sds_en", sds_en);
			baseMap.put("cas", cas);
			break;
			
		}
		return baseMap;
	}
}
