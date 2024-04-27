package net.java.practice.oauth.role;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long id;
    private String name;
}
