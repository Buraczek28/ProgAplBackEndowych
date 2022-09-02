package ProgAplBackEndowych.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BooksRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Books> getAll(){
        return jdbcTemplate.query("SELECT id, name, rating FROM Books",
                BeanPropertyRowMapper.newInstance(Books.class));


    }
}
