package com.codeusingjava.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

//lombok annotations
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ItemsDto {


    String itemsName;
    String material;
    String price;
    String promotionCode;
}
