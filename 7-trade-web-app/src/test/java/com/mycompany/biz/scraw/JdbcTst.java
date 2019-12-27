package com.mycompany.biz.scraw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Cleanup;

/**
* 测试时间处理(java.sql.Date,Time,Timestamp),取出指定时间段的数据
* @author 
*
*/
public class JdbcTst {

    /**
    * 将字符串代表的日期转为long数字(格式：yyyy-MM-dd hh:mm:ss)
    * @param dateStr
    * @return
    */
    public static long str2Date(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        ResultSet         rs   = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            @Cleanup
            Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trade?useUnicode=true", "stategen", "stategen");

            // ps = conn.prepareStatement("select * from t_user where regTime>? and regTime<?");
            // java.sql.Date start = new java.sql.Date(str2Date("2015-4-10 10:23:45"));
            // java.sql.Date end = new java.sql.Date(str2Date("2015-4-13 10:23:45"));
            // ps.setObject(1, start);
            // ps.setObject(2, end);

            var sql ="            select\r\n" + 
                    "            a.hoppy_id,\r\n" + 
                    "            a.hoppy_name,\r\n" + 
                    "            a.create_time,\r\n" + 
                    "            a.update_time,\r\n" + 
                    "            a.delete_flag\r\n" + 
                    "            from demo_hoppy a\r\n" + 
                    "            where\r\n" + 
                    "            a.delete_flag = 0\r\n" + 
                    "            and a.create_time <= ?";
            
            
            @Cleanup
            PreparedStatement ps = conn.prepareStatement(sql);
            var end   = new Date();
            ps.setObject(1, end);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                    rs.getInt("hoppy_id") + "--" + rs.getString("hoppy_name") + "--" + rs.getTimestamp("create_time"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}