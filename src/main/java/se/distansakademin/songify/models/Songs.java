package se.distansakademin.songify.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String songId;
    private String songName;
    private String songType;


}
