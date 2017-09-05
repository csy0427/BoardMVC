package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MemberBoardDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private int numOfPost=0;

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String url="jdbc:postgresql://localhost:5432/postgres";
        String username="postgres";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, "glqnf945");
    }

    public Map<String,Map<String,String>> getUserInfos() throws SQLException {
        Map<String,Map<String,String>> memberList=new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            numOfPost=0;
            connection = this.getConnection();
            System.out.println("success");
            preparedStatement=connection.prepareStatement("SELECT * FROM board");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String boardNumber = resultSet.getString("boardnumber");
                String title=resultSet.getString("title");
                String content=resultSet.getString("content");
                String views= resultSet.getString("views");
                Map<String,String> tmpMap=new HashMap<>();
                System.out.println(boardNumber+"-----------------");
                tmpMap.put("index",boardNumber);
                tmpMap.put("title",title);
                tmpMap.put("content",content);
                tmpMap.put("views",views);
                memberList.put(boardNumber,tmpMap);
                numOfPost++;
            }
            //preparedStatement=connection.prepareStatement("INSERT INTO member(id,password) VALUES (?,?)");
            //preparedStatement.setString(1,id);
            //preparedStatement.setString(2, String.valueOf(password));

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
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            getUserInfos();
            String num= String.valueOf(numOfPost);
            connection = this.getConnection();
            System.out.println("success");
            String defaultViews="0";
            preparedStatement=connection.prepareStatement("INSERT INTO board VALUES ('"+member.get("title")+"', '"+member.get("content")+"','"+defaultViews+"','"+num+"');");
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> get(String boardNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            Map<String,Map<String,String>> tmpList= getUserInfos();
            String views=String.valueOf(Integer.parseInt(tmpList.get(boardNumber).get("views"))+1);
            tmpList.get(boardNumber).put("views",views);
            System.out.println(views+"views");
            connection = this.getConnection();
            preparedStatement=connection.prepareStatement(" UPDATE board SET views = ? WHERE boardnumber = ?");
            preparedStatement.setString(1,views);
            preparedStatement.setString(2,boardNumber);
            preparedStatement.executeUpdate();
            return tmpList.get(boardNumber);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public void update(String index, Map<String, String> board) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = this.getConnection();
            System.out.println("success");
            String title=board.get("title");
            String content=board.get("content");
            preparedStatement=connection.prepareStatement(" UPDATE board SET title = ?, content = ? WHERE boardnumber = ?");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,content);
            preparedStatement.setString(3,index);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void delete(String boardNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = this.getConnection();
            System.out.println("success");
            preparedStatement=connection.prepareStatement(" DELETE FROM board WHERE boardnumber = ?");
            preparedStatement.setString(1,boardNumber);
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
