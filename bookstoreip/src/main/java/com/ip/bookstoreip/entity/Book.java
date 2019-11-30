package com.ip.bookstoreip.entity;
import javax.persistence.*;
@Entity
@Table(name = "book")
public class Book {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer books_id;
	 
	    @Column
	    private String name;
	 
	    @Column
	    private Integer price;
	 
	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name = "author_id")
	    private Author author;
	 
	    public Integer getId() {
	        return books_id;
	    }

	    public void setId(Integer id) {
	        this.books_id = id;
	    }
	    
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public Integer getPrice() {
	        return price;
	    }

	    public void setPrice(Integer p) {
	        this.price = p;
	    }
	    
	    public Author getAuthor() {
	        return author;
	    }

	    public void setAuthor(Author author) {
	        this.author = author;
	    }
	    @Override
	    public String toString() {
	        return "Book{" +
	                "id=" + books_id +
	                ", name='" + name + '\'' +
	                ", price='" + price + '\'' +
	                ", author='" + author + '\'' +
	                '}';
	    }
}
