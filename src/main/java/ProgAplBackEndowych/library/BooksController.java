package ProgAplBackEndowych.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

        @Autowired
        BooksRepository booksRepository;

        @GetMapping("/test")
        public int test(){
            return 1;
        }

        @GetMapping("/Books")
        public List<Books> getAll(){
            return booksRepository.getAll();
        }
}
