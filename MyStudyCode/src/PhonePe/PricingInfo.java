package PhonePe;

import java.math.BigDecimal;

public class PricingInfo {
    private CurrencyUnit currencyUnit;
    private BigDecimal value;

    public PricingInfo(CurrencyUnit currencyUnit, BigDecimal value) {
        this.currencyUnit = currencyUnit;
        this.value = value;
    }

    public CurrencyUnit getCurrencyUnit() {
        return currencyUnit;
    }

    public BigDecimal getValue() {
        return value;
    }
}
