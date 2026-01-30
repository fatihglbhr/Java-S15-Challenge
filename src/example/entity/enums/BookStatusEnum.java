package example.entity.enums;

public enum BookStatusEnum {
    AVAILABLE("Ödünç alınabilir."),
    BORROWED("Ödünç alınmış.");

    private final String status;

    BookStatusEnum(String status) {

        this.status = status;
    }

    public String getStatus() {

        return status;
    }
}
