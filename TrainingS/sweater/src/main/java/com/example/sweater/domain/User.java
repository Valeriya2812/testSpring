package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// чтобы айди самостоятельно генерировался
    private Long id;
    private String username;
    private String password;
    private boolean active;

    public User() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //FetchType.EAGER -при загрузке будет загружать все роли пользователя.  хорош, когда мало данных
    //FetchType.LAZY -при необходимостеи, только при запроси их
    @ElementCollection(targetClass = Role.class, fetch =  FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"))//поле будет храниться в отдельной таблице
    @Enumerated(EnumType.STRING)//пречисления хотим хранить в виде строки
    private Set<Role> roles;



}
