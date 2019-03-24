package br.com.fiap.paymentservice.Entity;

import lombok.*;

import javax.validation.constraints.Digits;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private int id = 0;
    private int cartao;
    private String validade;
    @Digits(integer = 6, fraction = 2)
    private float valor;
    private String bandeira;
}
