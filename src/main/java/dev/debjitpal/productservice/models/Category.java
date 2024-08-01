package dev.debjitpal.productservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;

    @OneToMany (mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
