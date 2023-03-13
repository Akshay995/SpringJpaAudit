package com.codeusingjava.dto;

import com.codeusingjava.model.Items;

import lombok.EqualsAndHashCode;
import lombok.Getter;

//lombok annotations
@Getter
@EqualsAndHashCode(callSuper = true)
public class ItemsResponse extends ItemsDto {

    String creationDate;
    String lastModifiedBy;
    String lastModifiedDate;

    private ItemsResponse(
            final String itemsName,
            final String material,
            final String price,
            final String promotionCode,
            final String creationDate,
            final String lastModifiedBy,
            final String lastModifiedDate) {
        super(itemsName, material, price, promotionCode);
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ItemsResponse from(final Items items) {
        return new ItemsResponse(items.getItemsName(),
                items.getItemsName(),
                items.getPrice(),
                items.getPromotionCode(),
                items.getCreationDate().toString(),
                items.getLastModifiedBy(),
                items.getLastModifiedDate().toString());
    }
}
