package example.entity.enums;

public enum BookTypesEnum {

    JOURNALS("Akademik Dergi"),
    STUDY_BOOKS("Çalışma Kitabı"),
    MAGAZINES("Dergi"),
    NOVELS("Roman");

    private final String type;

    BookTypesEnum(String type){

        this.type = type;
    }

    public String getType(){
        return type;
    }
}
