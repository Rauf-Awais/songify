package com.example.songify.DTO;

import lombok.Data;

@Data
public class SongDTO {
    private Long id;
    private String title;
    private String type;
    private int length;
}
