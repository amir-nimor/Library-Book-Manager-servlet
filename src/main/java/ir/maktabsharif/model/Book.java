package ir.maktabsharif.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigInteger;

@Entity
@Table(name = "Books")
public class Book extends BaseModel<Long>{



    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String Category;

    @Check(constraints = "price >= 0")
    private BigInteger price;

    public Book(String title, String author, String category, BigInteger price) {
        this.title = title;
        this.author = author;
        Category = category;
        this.price = price;
    }

    public Book() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + super.getId() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Category='" + Category + '\'' +
                ", price=" + price +
                '}';
    }
}

