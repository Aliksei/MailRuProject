package com.epam.poject.driver.webdriverFactory;

public enum  DriverEnum {


    FIREFOX("mozilla"),
    CHROME("chrome");


    private String type;

    DriverEnum(String requiredType) {
        type = requiredType;
    }

    private String getType(){
        return type;
    }

    public static DriverEnum defineEnumType(String type){

        for (DriverEnum enum_case: DriverEnum.values()){
            if(enum_case.getType().equals(type)){
                return enum_case;
            }
        }
        return null;
    }

}
