package Member;

import org.apache.commons.io.IOUtils;
import org.postgresql.Driver;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Member {

    private static String id;
    private static int password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

}
