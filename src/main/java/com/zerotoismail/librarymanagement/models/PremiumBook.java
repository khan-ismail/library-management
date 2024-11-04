package com.zerotoismail.librarymanagement.models;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PremiumBook extends Book {
    private int amount;
}
