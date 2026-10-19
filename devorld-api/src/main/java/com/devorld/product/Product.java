package com.devorld.product;
import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="DEVORLD_PRODUCTS") public class Product {
 @Id @Column(name="ID") private Long id;
 @Column(name="NAME") private String name;
 @Column(name="CATEGORY") private String category;
 @Column(name="PRICE") private BigDecimal price;
 @Column(name="RATING") private BigDecimal rating;
 @Column(name="DISCOUNT_PERCENT") private Integer discountPercent;
 @Column(name="IMAGE_URL") private String imageUrl;
 public Long getId(){return id;} public String getName(){return name;} public String getCategory(){return category;} public BigDecimal getPrice(){return price;} public BigDecimal getRating(){return rating;} public Integer getDiscountPercent(){return discountPercent;} public String getImageUrl(){return imageUrl;}
 public void setName(String v){name=v;} public void setCategory(String v){category=v;} public void setPrice(BigDecimal v){price=v;} public void setRating(BigDecimal v){rating=v;} public void setDiscountPercent(Integer v){discountPercent=v;} public void setImageUrl(String v){imageUrl=v;}
}
