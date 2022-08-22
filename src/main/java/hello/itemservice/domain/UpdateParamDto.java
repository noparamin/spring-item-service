package hello.itemservice.domain;

import lombok.Getter;

@Getter
public class UpdateParamDto {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public UpdateParamDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
