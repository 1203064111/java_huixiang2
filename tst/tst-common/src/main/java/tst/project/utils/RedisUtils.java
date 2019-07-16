package tst.project.utils;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	//private static String redis_ip="47.97.165.162";
	//private static String redis_ip="127.0.0.1";
	private static String redis_ip="127.0.0.1";
	private static String redis_key_title="";
	private static String redis_password="Zhengan777";
	private static int redis_concat_time=100000;
	private static int redis_port=6379;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1000;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 500;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10 * 1000;

    private static int TIMEOUT = 10 * 1000;//超时时间

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);

            config.setTestOnBorrow(TEST_ON_BORROW);//使用时进行扫描，确保都可用

            config.setTestWhileIdle(true);//Idle时进行连接扫描

            config.setTestOnReturn(true);//还回线程池时进行扫描
            
            
//
////表示idle object evitor两次扫描之间要sleep的毫秒数
//            config.setTimeBetweenEvictionRunsMillis(30000);
//
////表示idle object evitor每次扫描的最多的对象数
//            config.setNumTestsPerEvictionRun(10);
//
////表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
//            config.setMinEvictableIdleTimeMillis(60000);

            if (StringUtils.isNotBlank(redis_password)) {
                jedisPool = new JedisPool(config, redis_ip.split(",")[0], redis_port, TIMEOUT, redis_password);
            } else {
                jedisPool = new JedisPool(config, redis_ip.split(",")[0], redis_port, TIMEOUT);
            }
        } catch (Exception e) {
            try {
                //如果第一个IP异常，则访问第二个IP
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(MAX_ACTIVE);
                config.setMaxIdle(MAX_IDLE);
                config.setMaxWaitMillis(MAX_WAIT);
                config.setTestOnBorrow(TEST_ON_BORROW);
                jedisPool = new JedisPool(config, redis_ip.split(",")[1], redis_port, TIMEOUT, redis_password);
            } catch (Exception e2) {
            }
        }
    }
    
    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }


    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
        } finally {
            returnResource(jedis);//归还到Redis池里面
        }
        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 关闭连接池
     */
    public static void closePool() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }
    
    /**
     * 设置 String
     *
     * @param key
     * @param value
     */
    public synchronized static boolean setKey(String key, String value) {
        try {
            value = StringUtils.isEmpty(value) ? "" : value;
            getJedis().set(redis_key_title+key, value);
            return true;
        } catch (Exception e) {
        	return false;
        }
    }
    public synchronized static Set<String> getSetList(String key) {
        try {
//            value = StringUtils.isEmpty(value) ? "" : value;
//            getJedis().set(redis_key_title+key, value);
            Set<String> smembers = getJedis().smembers(key);
            return smembers;
        } catch (Exception e) {
        	return null;
        }
    }
    
    /**
     * 设置 过期时间
     *
     * @param key
     * @param seconds 以秒为单位
     * @param value
     */
    public synchronized static boolean setKey(String key, String value,int seconds) {
        try {
            value = StringUtils.isEmpty(value) ? "" : value;
            getJedis().setex(redis_key_title+key, seconds, value);
            return true;
        } catch (Exception e) {
        	return false;
        }
    }
    
    /**
     * 获取String值
     *
     * @param key
     * @return value
     */
    public synchronized static String getKey(String key) {
        if (getJedis() == null|| !getJedis().exists(redis_key_title+key)) {
            return null;
        }
//        Pipeline p = getJedis().pipelined();
//        Response<String> a=p.get(redis_key_title+key);
//        p.sync();
        return getJedis().get(redis_key_title+key);
    }
    
    public static void main(String[] args) {
//    	RedisUtils.setKey("citys", "123456");
//    	getJedis().del("member_id121");
   	setKey("member_id18","123456");
//    	getJedis().del("shop_banners");
//    	
    	System.out.println(RedisUtils.getKey("member_id18"));
//
//    	//getJedis().del("goods:detail56");
//    	System.out.println(RedisUtils.getKey("account_id2"));

//    	Set s = getJedis().keys("*");
//		Iterator it = s.iterator();
//		while (it.hasNext()) {
//			String key = (String) it.next();
//			getJedis().del(key);
//		}
	}

    
//    public static void main(String[] args) {
//        // 连接池
//    	JedisPoolConfig config = new JedisPoolConfig();
//        JedisPool jedisPool = new JedisPool(config,"47.97.165.162", 6379,TIMEOUT, redis_password);
//        
//        /* 操作Redis */
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            
//            System.out.println("开始时间"+TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
//            
//            System.out.println("操作前，全部Key值：" + jedis.keys("*"));
//            Pipeline p = jedis.pipelined();
//           
//            Response<String> a=null;
//            
//            
//            for(Integer i = 0; i < 1000; i++) {
//            	p.set(i.toString(), (i+1)+"");
//                a=p.get(i.toString());
//            }
//            p.sync();
//            System.out.println(a.get());
//            System.out.println("操作后，全部Key值：" + jedis.keys("*"));
//            
//            System.out.println("开始时间"+TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
//            
//           
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//    }
}
