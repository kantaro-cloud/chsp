package cn.kantaro.entity;

import lombok.Data;

@Data
public class MyMenu extends BaseEntity<Integer>{

    private static final long serialVersionUID = -6525908145032868815L;
    private Integer parentId;
    private String name;
    private String icon;
    private Integer type;
    private String url;
    private String permission;
    private Integer sort;
}
