package ru.kpfu.itis.dao.impl.jdbc;

import org.hibernate.criterion.Order;
import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriversDaoJdbcImpl implements DriversDao {


    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void save(Driver driver) {

    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        List<Driver> drivers = new ArrayList<Driver>();
        String sql = "SELECT * from drivers ORDER BY rating DESC LIMIT 9";
        Driver driver = null;
        try {
            con = getConnection();
            ptmt = con.prepareStatement(sql);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                driver = new Driver();
                driver.setRating(rs.getInt("rating"));
                driver.setId(rs.getLong("id"));
                driver.setExperience(rs.getInt("experience"));
                drivers.add(driver);
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (ptmt != null)
                    con.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        return drivers;
    }
    }
}
