package com.example.batch.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class DatoEntrada {

    private String id;

    private BigDecimal price;

    private BigDecimal amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DatoEntrada that = (DatoEntrada) o;

        return new EqualsBuilder().append(id, that.id).append(price, that.price).append(amount, that.amount).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(price).append(amount).toHashCode();
    }
}
