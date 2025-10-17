import java.math.BigDecimal;

/**
 * DTO for Inventory data transfer
 */
public class InventoryDto {

    private Integer idInventory;
    private Integer idProduct;
    private Integer quantity;
    private String productSize;
    private BigDecimal productPrice; 
    private String barCode;

    // --- Constructors ---

 
    public InventoryDto() {
    }

    public InventoryDto(Integer idInventory, Integer idProduct, Integer quantity, String productSize, BigDecimal productPrice, String barCode) {
        this.idInventory = idInventory;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.productSize = productSize;
        this.productPrice = productPrice;
        this.barCode = barCode;
    }


    // --- Getters & Setters ---

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }


    // --- toString ---

    @Override
    public String toString() {
        return "InventoryDto{" +
                "idInventory=" + idInventory +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", productSize='" + productSize + '\'' +
                ", productPrice=" + productPrice +
                ", barCode='" + barCode + '\'' +
                '}';
    }
}