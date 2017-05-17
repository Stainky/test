import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by lijie12 on 2017/3/23.
 */
public class JdbcUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcUtil.class);
    public static String url = "jdbc:mysql://172.17.70.3:3306/offline_ghotel" ;
    public static String username = "admin" ;
    public static String password = "tuniu520" ;

//    private static String IP1 = "http://10.40.189.58:17401";
//    private static String IP2 = "http://10.40.189.58:17402";
//    private static String IP3 = "http://10.40.189.63:17401";
//    private static String IP4 = "http://10.40.189.63:17402";
    private static String IP1 = "http://10.40.189.88:17501";
    private static String IP2 = "http://10.40.189.88:17502";
    private static String IP3 = "http://10.40.189.93:17501";
    private static String IP4 = "http://10.40.189.93:17502";
    // 获取mapping酒店数据接口
//    private static String MAPPING_SUFFIX = "/map-ghotel-main/manage/hotel/map/list";
    // 酒店上线下接口
//    private static String OFFLINE_SUFFIX = "/map-ghotel-main/map/hotel/ris-index";
    // 万能接口
//    private static String OMNIPOTENCE_SUFFIX = "/map-ghotel-main/manage/lunaSql";
    private static String OMNIPOTENCE_SUFFIX = "/res-ghotel-main/room/lunaSql";

    public static Connection getConnection() {
        try {
            int count = 0;
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);
            while(null == conn && count < 3) {
                count ++;
                LOG.info("get db connection failed，retry the {} time...", count);
                conn = (Connection) DriverManager.getConnection(url, username, password);
            }
            return conn;
        } catch(Exception e) {
            LOG.error("get db connection error!{}", e);
        }
        return null;
    }

    public static PreparedStatement getStatement(Connection conn, String sql) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            LOG.error("[getStatement] error:{}", e);
        }
        return null;
    }

//    public static String getMappingUrl() {
//        return getIP() + JdbcUtil.MAPPING_SUFFIX;
//    }

//    public static String getOfflineHotelUrl() {
//        return getIP() + JdbcUtil.OFFLINE_SUFFIX;
//    }

    public static String getOmnipotencelUrl() {
        return getIP() + JdbcUtil.OMNIPOTENCE_SUFFIX;
    }

    public static String getIP() {
        String ip = null;
        Random r = new Random();
        int selected = r.nextInt(4);
        switch(selected) {
            case 0 :
                ip = IP1;
                break;
            case 1 :
                ip = IP2;
                break;
            case 2 :
                ip = IP3;
                break;
            case 3 :
                ip = IP4;
                break;
        }
        return ip;
    }

}
