CREATE TABLE `chart_datasource`
(
  `id`                 bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name`               varchar(64) NOT NULL COMMENT '数据源名称',
  `type`               tinyint(1) DEFAULT NULL COMMENT '数据源类型',
  `request_url`        varchar(1024) DEFAULT NULL COMMENT '请求地址',
  `request_method`     varchar(10)   DEFAULT NULL COMMENT '请求方法',
  `request_header`     varchar(1024) DEFAULT NULL COMMENT '请求头',
  `request_body`       text COMMENT '请求body',
  `response_body`      text COMMENT '返回body',
  `static_data`        text COMMENT '静态数据',
  `data_path`          varchar(1024) DEFAULT NULL COMMENT '数据路径',
  `created_date`       datetime      DEFAULT NULL COMMENT '创建日期',
  `last_modified_date` datetime      DEFAULT NULL COMMENT '最后更新日期',
  `created_by`         bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modified_by`   bigint(20) DEFAULT NULL COMMENT '最后更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据源信息';

CREATE TABLE `chart_theme`
(
  `id`                 bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name`               varchar(64) NOT NULL COMMENT '主题名称',
  `style`              text COMMENT '样式',
  `create_date`        datetime DEFAULT NULL COMMENT '创建日期',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后修改日期',
  `created_by`         bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modified_by`   bigint(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主题样式';

CREATE TABLE `chart_design`
(
  `id`                 bigint(20) NOT NULL COMMENT '主键ID',
  `name`               varchar(64) DEFAULT NULL COMMENT '图表名称',
  `design`             text COMMENT '图表设计',
  `datasource_id`      bigint(20) DEFAULT NULL COMMENT '数据源id',
  `theme_id`           bigint(20) DEFAULT NULL COMMENT '主题id',
  `created_date`       datetime    DEFAULT NULL COMMENT '创建日期',
  `last_modified_date` datetime    DEFAULT NULL COMMENT '最后修改日期',
  `created_by`         bigint(20) DEFAULT NULL COMMENT '创建人',
  `last_modified_by`   bigint(20) DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图表设计信息';