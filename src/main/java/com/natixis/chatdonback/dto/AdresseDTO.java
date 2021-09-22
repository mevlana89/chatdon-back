package com.natixis.chatdonback.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdresseDTO {
    private String rue;
    private int CodePostal;
    private String ville;
}
