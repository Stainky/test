import com.tuniu.common.utils.client.RestUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijie12 on 2017/3/24.
 */
public class WNJKInvoker {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static Statement stmt = null;

    public static String subString(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static void process() throws Exception {
        init();
        int count = 0;
        ResultSet rs = stmt.executeQuery("SELECT count(1) as snum FROM hotel_room where del_flag = 1") ;
        while(rs.next()){
            count = rs.getInt(1) ;
        }
        int start = 0;
        int limit = 10;
        while(start < count + limit) {
            init();
            ResultSet rss = stmt.executeQuery("select id from hotel_room where del_flag = 1 limit " + start +", " + limit + "");
            StringBuilder sb = new StringBuilder();
            while(rss.next()) {
                sb.append(rss.getInt(1)).append(",");
            }
            String sql = subString(sb.toString());
            sql = "update hotel_room set del_flag = 1 where id in (" + sql + ")";
            remoteCall(sql);
            start += limit;
        }
    }

    public static void init() throws Exception {
        conn = getConnection();
        StringBuilder sb = new StringBuilder();
        stmt = conn.createStatement() ;
    }

    public static void remoteCall(String sql) throws Exception {
        String result = RestUtil.execute(JdbcUtil.getOmnipotencelUrl(), "POST", "{\"context\":\"" + sql + "\"}");
        if(!result.contains("success\":true")) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        try {
//            init();
            process();
        } catch(Exception e) {
            e.printStackTrace();
        }


//        String[] sql = {
//
//        };
//        for(int i = 0; i < sql.length; i++) {
//            String result = RestUtil.execute(JdbcUtil.getOmnipotencelUrl(), "POST", "{\"context\":\"" + sql[i] + "\"}");
//            if(!result.contains("success\":true")) {
//                System.out.println(result);
//            }
//
//        }


    }


    public static Connection getConnection() {
        String url = "jdbc:mysql://172.17.70.3:3306/offline_ghotel" ;
        String username = "admin" ;
        String password = "tuniu520" ;
        try{
            conn = DriverManager.getConnection(url , username , password ) ;
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
        return conn;
    }
}
