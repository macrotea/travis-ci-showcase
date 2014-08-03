package cn.macrotea.showcase.dto;

public enum ActionEnum {

    CREATE("新增"), EDIT("编辑"), LIST("查询"),;

    private String desc;

    ActionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}