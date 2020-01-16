package com.martini.api.entity;

import javax.persistence.*;

@Entity //SE DECLARA QUE LA CLASE ES UNA ENTITY
@Table(name = "users") //NOMBRE DE LA TABLA DE LA BD
public class User {

    @Id  //NOTACIÓN PARA INDICAR QUE ES UN ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //NOTACIÓN PARA INDICAR EL AUTOINCREMENTO
    public Long id;
    @Column(name = "name")//NOMBRES DE LA TABLA EN LA BD RELACIONADA AL ATRIBUTO DE ABAJO
    public String name;
    @Column(name = "username")
    public String username;

    public User() {
    }

    public User(Long id, String name, String username) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

}
