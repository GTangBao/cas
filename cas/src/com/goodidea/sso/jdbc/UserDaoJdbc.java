package com.goodidea.sso.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.goodidea.sso.entity.User;

@Repository
public class UserDaoJdbc {
    
    private static final String SQL_USER_GET = "SELECT * FROM sso_users WHERE t_username=? and t_isdel='0' ";
    
    private JdbcTemplate jdbcTemplate;
    
    @Resource
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public User verifyAccount(String username){
        try{
            //验证用户名和密码是否正确
        	return this.jdbcTemplate.queryForObject(SQL_USER_GET, new Object[]{username},new UserRowMapper());
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    
	public User getByUsername(String username) {
		
		return this.jdbcTemplate.queryForObject(SQL_USER_GET, new Object[]{username},new UserRowMapper());
		
	}
	
	public void update(final User user){
		  jdbcTemplate.update(  
	                "update sso_users set  t_locaked=?,t_locked_date=? where t_username = ?",   
	                new PreparedStatementSetter(){  
	                    @Override  
	                    public void setValues(PreparedStatement ps) throws SQLException {  
	                    	ps.setInt(1, user.getIsLocked());  
	                    	ps.setTimestamp(2, new Timestamp(new Date().getTime()));
	                        ps.setString(3, user.getUsername());  
	                    }

	                }  
	        );  
	}
	
	
	class UserRowMapper implements RowMapper<User> {
	    @Override
	    public User mapRow(ResultSet rs, int index) throws SQLException {
	        User user = new User();
	        user.setId(rs.getString("id"));
	        user.setUsername(rs.getString("t_username"));
	        user.setPassword(rs.getString("t_password"));
	        user.setEnabled(rs.getInt("t_enable"));
	        user.setIsLocked(rs.getInt("t_locked"));
	        return user;
	    }
	}
}
