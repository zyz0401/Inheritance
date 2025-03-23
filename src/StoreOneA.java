class StoreToRent {
    private final double INTEREST_RATE = 0.25;
    private boolean loanRequired;
    private double loanAmount;
    private int loanPaymentTerm;

    public StoreToRent(boolean loanRequired, double loanAmount, int loanPaymentTerm) {
        this.loanRequired = loanRequired;
        this.loanAmount = loanAmount;
        this.loanPaymentTerm = loanPaymentTerm;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    public boolean isLoanRequired() {
        return loanRequired;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPaymentTerm() {
        return loanPaymentTerm;
    }

    public double calculateLoanFinancing() {
        if (loanRequired) {
            return (loanAmount * (1 + INTEREST_RATE)) / loanPaymentTerm;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "This is parent class toString()";
    }
}

class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public boolean isSpecialCustomer() {
        return specialCustomer;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            double DISCOUNT_RATE = 0.1; // 假设折扣率为0.1
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "Combining parent toString() \n" + super.toString() + "\n and child toString()\n" +
                "LOAN DETAILS (if applicable):\n" +
                "Loan Amount: " + getLoanAmount() + "\n" +
                "Loan Payment Term: " + getLoanPaymentTerm() + "\n" +
                "Interest Rate: " + getINTEREST_RATE() + "\n" +
                "Special Customer: " + specialCustomer + "\n" +
                "Monthly Loan Payment: " + calculateLoanFinancing();
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }
}
