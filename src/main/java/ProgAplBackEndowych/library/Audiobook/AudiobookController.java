package ProgAplBackEndowych.library.Audiobook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

public class AudiobookController {

    @Autowired
    AudiobookRepository audiobookRepository;


    @RequestMapping("/audiobooks")
    public List<Audiobook> getAll(){
        return audiobookRepository.getAll();
    }

    @RequestMapping("/audiobooks/{id}")
    public Audiobook getById(@PathVariable("id") int id){
        return audiobookRepository.getById(id);
    }

    @PostMapping("/audiobooks")
    public int add(@RequestBody List<Audiobook> audios){
        return audiobookRepository.save(audios);
    }

    @PutMapping("/audiobooks/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Audiobook updatedAudio){
        Audiobook audio = audiobookRepository.getById(id);

        if (audio !=null){
            audio.setName(updatedAudio.getName());
            audio.setRating(updatedAudio.getRating());

            audiobookRepository.update(audio);

            return 1;
        } else{
            return -1;
        }
    }

    @DeleteMapping("/audiobooks/{id}")
    public int delete(@PathVariable("id") int id) {
        return audiobookRepository.delete(id);

    }
}
