package uz.avotech.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import uz.avotech.domain.User;
import uz.avotech.errors.LoginException;
import uz.avotech.errors.PasswordException;
import uz.avotech.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final NamedParameterJdbcTemplate template;
    private final UserMapper userMapper;


    public String getTitle() {
        return "my page";
    }

    public void save(@Valid User user) {

        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getLogin());
        params.put("password", user.getPassword());

        template.update("insert into myusers (name, password) values (:name, :password)", params);
    }

    public List<User> getAll() {
        return template.query("select * from myusers",
                (rs, count) -> new User(rs.getString("name"), rs.getString("password")));
    }

}
