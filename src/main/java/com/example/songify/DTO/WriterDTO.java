package com.example.songify.DTO;

import com.example.songify.models.Writer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WriterDTO {

    private String id;
    private String name;
    private String dateOfBirth;
    private String email;


    public WriterDTO (Writer writer){
        this.id = writer.getId();
        this.name = writer.getName();
        this.dateOfBirth = writer.getDateOfBirth();
        this.email = writer.getEmail();
    }

    public Writer toWriter(){
        return new Writer(id,name,dateOfBirth,email,null);
    }




}
