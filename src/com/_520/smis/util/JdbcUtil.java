package com._520.smis.util;

import com._520.smis.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static String diverClassName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "admin";
    //静态代码块只加载一次
    static {
        try {
            //加载注册驱动
            Class.forName(diverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接对象
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    //释放资源
    public static void close(ResultSet rs, Statement st, Connection con){
        try {
            if(rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(st != null)
                    st.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(con != null)
                        con.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * DML
     * @param sql       SQL语句模板
     * @param obj       ?具体的值
     */
    public static void upDate(String sql, Object ... obj){
        Connection con  =null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getConnection();
            //获取语句对象
            ps = con.prepareStatement(sql);
            //设置参数值
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1,obj[i]);
            }
            //执行
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //
            close(null,ps,con);
        }
    }
    public static List<Student> query(String sql, Object...objects){
        List<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //获取连接对象
        con = getConnection();

        try {
            //获取连接语句
            ps =con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            //执行sql语句
            ps.executeQuery();

            //处理结果集
            rs = ps.executeQuery();
            while (rs.next()){
                Student stu = new Student();
                list.add(stu);
                //将结果集中的数据添加到stu对象中
                stu.setId(rs.getLong("id"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("math"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        close(rs,ps,con);
        return list;
    }
}
