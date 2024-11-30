package com.allianceenterprise.allianceCenter.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OutText {
    private String phrase;
    private boolean match;
}
