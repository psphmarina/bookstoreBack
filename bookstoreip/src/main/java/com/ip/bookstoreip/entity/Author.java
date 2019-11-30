package com.ip.bookstoreip.entity;
import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
 
    @Column
    private String name;
 
    @Column
    private String surname;
    
    @Column
    private String patronymic;
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronomic='" + patronymic + '\'' +
                '}';
    }
}
