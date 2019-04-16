package com.github.knafelek.pilesapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, nullable = false)
    private String username;
    @Column (nullable = false)
    private String password;
    @Column (name="first_name")
    private String firstName;
    @Column (name="last_name")
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
