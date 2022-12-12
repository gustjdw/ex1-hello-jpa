package jpabasic.ex1hellojpa.hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @DiscriminatorColumn  // DTYPE, SINGLE_TABLE, TABLE_PER_CLASS 에선 없어도 됨
public abstract class Item {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
