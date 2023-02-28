package com.example.examensegundaevaluacion.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class Usuario implements Serializable {
    @Id
    private String id;
    @Field("username")
    @Indexed(unique = true)
    private String username;
    @Field("first_name")
    private String nombre;
    @Field("last_name")
    private String apellido;
    @Field("email")
    @Indexed(unique = true)
    private String email;
}
