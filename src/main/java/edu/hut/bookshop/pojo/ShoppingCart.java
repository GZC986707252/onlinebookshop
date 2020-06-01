package edu.hut.bookshop.pojo;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class ShoppingCart {
    private Integer cartId;

    private Integer userId;

    private Integer bookId;

    private BigDecimal price;

    @Min(value = 0,message = "购买数量只能大于或者等于0")
    private Integer quantity;

    private Book book_info;

    public Book getBook_info() {
        return book_info;
    }

    public void setBook_info(Book book_info) {
        this.book_info = book_info;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}