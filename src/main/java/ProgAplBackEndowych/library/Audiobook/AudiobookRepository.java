package ProgAplBackEndowych.library.Audiobook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class AudiobookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Audiobook> getAll(){
        return jdbcTemplate.query("SELECT id, name, rating FROM Audiobook",
                BeanPropertyRowMapper.newInstance(Audiobook.class));

    }

    public Audiobook getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, rating FROM Audiobook WHERE id=?", BeanPropertyRowMapper.newInstance(Audiobook.class), id);
    }


    public int save(List<Audiobook> audios) {
        audios.forEach(audio -> jdbcTemplate.update("INSERT INTO Audiobook(name, rating) VALUES(?, ?)",audio.getName(), audio.getRating() ));


        return 1;
    }

    public int update(Audiobook audio){
        return jdbcTemplate.update("UPDATE Audiobook SET name=?, rating=? WHERE id=?",
                audio.getName(), audio.getRating(), audio.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM Audiobook WHERE id=?", id);
    }

}
