package software.kalender.pocketcase.enums;

public enum CurrencyEnum {
    USD {
        @Override
        String code() {
            return "USD";
        }

        @Override
        String symbol() {
            return "$";
        }
    },

    EUR {
        @Override
        String code() {
            return "EUR";
        }

        @Override
        String symbol() {
            return "€";
        }
    },

    TRY {
        @Override
        String code() {
            return "TRY";
        }

        @Override
        String symbol() {
            return "₺";
        }

        @Override
        public Long awardedVideoAmount() {
            return 50000L;
        }
    },

    RUB {
        @Override
        String code() {
            return "RUB";
        }

        @Override
        String symbol() {
            return "₽";
        }

        @Override
        public Long awardedVideoAmount() {
            return 5000000L;
        }
    },

    GBP {
        @Override
        String code() {
            return "GBP";
        }

        @Override
        String symbol() {
            return "£";
        }
    };

    abstract String code();

    abstract String symbol();

    public String formatWithSymbol(Long amount) {
        String _amount = amount.toString();

        if (amount > 100) {
            return String.format("%1$s.%2$s %3$s",
                    _amount.substring(0, _amount.length() - 2),
                    _amount.substring(_amount.length() - 2, _amount.length()),
                    symbol()
            );
        } else {
            return String.format("0.%1$s %1$s",
                    amount,
                    symbol()
            );
        }
    }

    public String formatWithCode(Long amount) {
        String _amount = amount.toString();

        if (amount > 100) {
            return String.format("%1$d.%2$d %3$s",
                    _amount.substring(0, _amount.length() - 2),
                    _amount.substring(_amount.length() - 2, _amount.length()),
                    code()
            );
        } else {
            return String.format("0.%1$d %1$s",
                    amount,
                    code()
            );
        }
    }

    public Long awardedVideoAmount(){
        return 5000L;
    }
}
