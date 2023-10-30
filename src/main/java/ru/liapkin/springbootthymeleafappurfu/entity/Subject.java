package ru.liapkin.springbootthymeleafappurfu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@Table(name = "SUBJECTS")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    public Subject() {

    }

    public Subject(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
}
