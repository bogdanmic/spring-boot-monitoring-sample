package dev.spring.simple.service.persistance.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "simple_service_contacts", schema = "public")
@Data
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
}
