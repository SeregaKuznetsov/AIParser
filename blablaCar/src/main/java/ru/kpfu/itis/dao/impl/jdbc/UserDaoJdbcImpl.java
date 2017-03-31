package ru.kpfu.itis.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.dao.impl.hibernate.AutosDaoHibernateImpl;
import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbcImpl implements UsersDao{

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }
    @Override
    public void save(User user) {
        try {
            con = getConnection();
            ptmt = con.prepareStatement("INSERT INTO users (avatar, email, firstname, nickname, password, role, surname) VALUES (?, ?, ?, ?, ?, ?, ?);");
            ptmt.setString(1, user.getAvatar());
            ptmt.setString(2, user.getEmail());
            ptmt.setString(3, user.getFirstname());
            ptmt.setString(4, user.getNickname());
            ptmt.setString(5, user.getPassword());
            ptmt.setString(6, user.getRole());
            ptmt.setString(7, user.getSurname());

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(ptmt!=null)
                    con.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }

    }

    @Override
    public User findOne(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByNickname(String nickname) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByNicknameIgnoreCase(String name) {
        String sql = "select * from users where lower(nickname) = lower(?)";
        User user = null;


        try {
            con = getConnection();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setNickname(rs.getString(("nickname")));
                user.setFirstname(rs.getString("firstname"));
                user.setSurname(rs.getString("surname"));
                user.setAvatar(rs.getString("avatar"));
                user.setRole(rs.getString("role"));
                user.setId(rs.getLong("id"));
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
            return user;
        }
    }

        @Override
        public User findByEmailIgnoreCase (String email){
            return null;
        }
    }
