package cn.edu.ncu.learn.util;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Desc: MongoDB 的jdbc连接工具类
 * @author Carlos Leo
 * @author qinglew@outlook.com
 * Time: 2019/5/4 - 20:30
 */
public class MongoJDBC {
    private static MongoDatabase database = null;
    private static final Class<MongoJDBC> LOCK = MongoJDBC.class;

    /**
     * 获取数据库
     * @return database
     */
    public static MongoDatabase getDatabase() {
        synchronized (LOCK) {
            if (database == null) {
                try {
                    //可以修改ip以给不同的主机插入数据
                    MongoClient mongoClient = new MongoClient("192.168.206.129", 27017);
                    database = mongoClient.getDatabase("school");
                    System.out.println("Connect to database successfully");
                } catch (Exception e) {
                    System.err.println("Connect to database failed");
                    e.printStackTrace();
                }
            }
        }
        return database;
    }
}
