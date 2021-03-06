package dao;

import model.Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avega on 02.06.14.
 */
public class RoleDao implements IRoleDao {


    public RoleDao() {
        try {
            System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAllRole() {
        ArrayList<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM taskcontrol.roles";

        Role retValue = null;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();
                while (res.next()) {
                    retValue = new Role(res.getInt("id"), res.getString("role_name"));
                    roles.add(retValue);

                }

            } finally {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (res != null) {
                    res.close();
                    res = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }


}
