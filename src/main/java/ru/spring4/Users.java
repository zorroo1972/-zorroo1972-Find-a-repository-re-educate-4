package ru.spring4;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Users")
public class Users
{
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "USERNAME", nullable = false)
    String username;
    @Column(name = "FIO", nullable = false)
    String fio;

    public Users() {
    }



    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}


