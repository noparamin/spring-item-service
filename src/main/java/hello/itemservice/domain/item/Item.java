package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter // @Data 가급적 안 쓰기, DTO에는 확인해서 쓰기
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
