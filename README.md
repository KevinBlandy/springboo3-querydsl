
## Scheme

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint UNSIGNED NOT NULL COMMENT 'ID',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` tinyint UNSIGNED NOT NULL COMMENT '是否启用。0：禁用，1：启用',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `instruction` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'path',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `title`(`title`) USING BTREE COMMENT 'title',
  UNIQUE INDEX `path`(`path`) USING BTREE COMMENT 'path'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '帖子标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint UNSIGNED NOT NULL COMMENT 'ID',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` bigint UNSIGNED NOT NULL COMMENT '是否删除。0：未删除，非0：删除时间戳',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `enabled` tinyint UNSIGNED NOT NULL COMMENT '是否启用。0：false，1：true',
  `html_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '渲染后的HTML',
  `poster` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `keywords` json NULL COMMENT '关键字',
  `markdown_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '原始Markdown文档',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '路径',
  `preview` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预览',
  `publicly` tinyint UNSIGNED NOT NULL COMMENT '是否是公开的。0：false，1：true',
  `reference` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '引用来源',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `toc` tinyint UNSIGNED NOT NULL COMMENT '是否渲染目录。0：false，1：true',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `version` int UNSIGNED NOT NULL COMMENT 'version',
  `views` int UNSIGNED NULL DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `path`(`path`, `deleted`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post_tag
-- ----------------------------
DROP TABLE IF EXISTS `post_tag`;
CREATE TABLE `post_tag`  (
  `post_id` bigint UNSIGNED NOT NULL COMMENT '帖子ID',
  `tag_id` bigint UNSIGNED NOT NULL COMMENT '标签ID',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`post_id`, `tag_id`) USING BTREE,
  INDEX `tag_id`(`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '帖子 - 标签' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

```
