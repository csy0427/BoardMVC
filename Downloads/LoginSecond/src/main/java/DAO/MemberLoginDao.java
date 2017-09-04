package DAO;

import Member.Member;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MemberLoginDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, "glqnf945");
    }

    public Map<String,Map<String,String>> getUserInfos() throws SQLException {
        Map<String,Map<String, String>> memberList=new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            connection = this.getConnection();
            System.out.println("success");
            preparedStatement=connection.prepareStatement("SELECT * FROM member");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String password = resultSet.getString(2);
                System.out.println(id +"*****"+ password);
                Map<String, String> tmpMap=new HashMap<>();
                tmpMap.put("password",password);
                memberList.put(id,tmpMap);
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    public void add(Map<String, String> member) {

    }
}
