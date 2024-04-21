public class OrderReceipt {
    private final String restoName = "SKULL CHICKEN", customerCare = "081071231999", restoAddress = "Jalan Anu Raya, no. 999, Tamalanrea";
    private String orderId, cashierName, dateTime, customerName, orderName;
    private int price, quantity;

    public OrderReceipt(String cashierName) {
        this.cashierName = cashierName;
    }

    public OrderReceipt() {}

    // Non-final attributes
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void showOrderReceipt() {
        System.out.println(
            "\n" + "=".repeat(60) + "\n" +
            " ".repeat(24) + this.restoName + "\n" +
            " ".repeat(12) + this.restoAddress + "\n" +
            " ".repeat(24) + this.customerCare + "\n" +
            "-".repeat(60) + "\n\n\n\n" +
            "Id pesanan : " + this.orderId + "\n" +
            "Pembeli    : " + this.customerName + "\n" +
            "Kasir      : " + this.cashierName + "\n" +
            " ".repeat(43) + this.dateTime + "\n" +
            "=".repeat(60) + "\n" +
            "Pesanan" + " ".repeat(33) + this.orderName + "\n" +
            "Harga" + " ".repeat(35) + "Rp" + this.price + "\n" +
            "Jumlah" + " ".repeat(34) + this.quantity + "\n" +
            "-".repeat(60) + "\n" +
            "Total" + " ".repeat(35) + "Rp" + (this.price * this.quantity) + "\n" +
            "=".repeat(60) + "\n"
        );
    }
}