package web.service.restful.device_management.Models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employees", indexes = {
        @Index(name = "IDX_username", columnList = "username"),
        @Index(name = "IDX_email", columnList = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(unique = true)
    private String email;

    private String profilePictureUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Device> devices = new ArrayList<>();

    public Employee(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
