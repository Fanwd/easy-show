package com.glodon.easyshow.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 主题样式
 */
@Entity
@Table(name = "chart_theme")
public class ChartThemeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    /**
     * 主题名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 样式
     */
    @Column(name = "style")
    private String style;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Timestamp createDate;

    /**
     * 最后修改日期
     */
    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 最后修改人
     */
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;


}