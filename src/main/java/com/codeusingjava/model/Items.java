package com.codeusingjava.model;

import lombok.*;
import org.springframework.stereotype.Component;

import com.codeusingjava.audit.Auditable;

import javax.persistence.*;

//lombok annotations
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
//spring jpa annotations
@Entity
@Table(name = "itemss")
//spring annotation
@Component
public class Items extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "name", nullable = true)
    String itemsName;
   String material;
    String price;
    @Column(name = "promotionCode")
    String promotionCode;

}
