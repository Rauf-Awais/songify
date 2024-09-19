package com.example.songify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String Name;
    private String dateOfBirth;
    private String email;

    @OneToMany(mappedBy = "songWriter" , cascade = CascadeType.ALL)
    private List<Song> songs;
    
}
