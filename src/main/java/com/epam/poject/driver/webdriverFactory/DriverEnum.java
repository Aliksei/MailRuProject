package com.epam.poject.driver.webdriverFactory;

import com.epam.poject.exceptions.DriverEnumException;

public enum  DriverEnum {

    FIREFOX("mozilla"),
    CHROME("chrome"),
    I_EXPLORER("explorer");

    private String type;


    DriverEnum(String requiredType) {
        type = requiredType;
    }

    private String getType(){
        return type;
    }

    public static DriverEnum defineEnumType(String type) throws DriverEnumException {
            for (DriverEnum enum_case : DriverEnum.values()) {
                if (enum_case.getType().equals(type)) {
                    return enum_case;
                }
            }
            throw new DriverEnumException("Cant define the type of browser");
    }
}
