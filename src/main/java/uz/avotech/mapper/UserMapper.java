package uz.avotech.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import uz.avotech.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String password = rs.getString("password");
        User user = new User(name, password);
        return user;
    }
}
