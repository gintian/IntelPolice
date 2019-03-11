package com.constant;

public enum Indicator {

    /**
     * 字典类型
     */
    PERMISSION_TYPE("1", "权限"), USER_TYPE("5", "用户类型");



    private String code;
    private String label;

    Indicator(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public boolean isCodeEquals(String codeValue) {
        if (codeValue == null) {
            return false;
        }
        return codeValue.equals(this.getCode());
    }
}
