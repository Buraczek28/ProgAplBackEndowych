package ProgAplBackEndowych.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Books {
    private int id;
    private String Name;
    private int Rating;
}
