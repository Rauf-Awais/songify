package com.example.songify.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String title;
    private String type;
    private int length;

    @ManyToOne
    private Writer songWriter;

}
