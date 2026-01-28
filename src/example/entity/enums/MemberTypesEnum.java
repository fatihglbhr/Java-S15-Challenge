package example.entity.enums;

public enum MemberTypesEnum {
    STUDENT("Student"),
    FACULTY("Faculty");

    private final String type;

    MemberTypesEnum(String type){

        this.type = type;
    }

    public String getType(){

        return type;
    }
}
