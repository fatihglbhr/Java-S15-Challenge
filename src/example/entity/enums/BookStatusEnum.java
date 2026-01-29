package example.entity.enums;

public enum BookStatusEnum {
    AVAILABLE("Available"),
    BORROWED("Borrowed");

    private final String status;

    BookStatusEnum(String status) {

        this.status = status;
    }

    public String getStatus() {

        return status;
    }
}
