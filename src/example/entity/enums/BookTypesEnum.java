package example.entity.enums;

public enum BookTypesEnum {

    JOURNALS("Journals"),
    STUDY_BOOKS("Study Books"),
    MAGAZINES("Magazines");

    private final String type;

    BookTypesEnum(String type){

        this.type = type;
    }

    public String getType(){
        return type;
    }
}
