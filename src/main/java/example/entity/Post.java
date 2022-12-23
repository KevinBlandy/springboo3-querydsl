package example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;



@Entity
@Table(name = "post", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"path", "deleted"}, name = "path")
})
@org.hibernate.annotations.Table(appliesTo = "post", comment = "文章")
public class Post {
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(columnDefinition = "BIGINT UNSIGNED COMMENT 'ID'")
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(500) COMMENT '标题'", nullable = false)
	private String title;
	
	@Column(columnDefinition = "VARCHAR(50) COMMENT '路径'", nullable = false)
	private String path;
	
	@Column(columnDefinition = "VARCHAR(500) COMMENT '预览'")
	private String preview;
	
	@Column(columnDefinition = "VARCHAR(500) COMMENT '封面图片'")
	private String poster;
	
	@Column(columnDefinition = "JSON COMMENT '关键字'")
	private String keywords;
	
	@Column(columnDefinition = "VARCHAR(500) COMMENT '描述'")
	private String description;
	
	@Column(columnDefinition = "MEDIUMTEXT COMMENT '渲染后的HTML'", nullable = false)
	private String htmlContent;
	
	@Column(columnDefinition = "MEDIUMTEXT COMMENT '原始Markdown文档'", nullable = false)
	private String markdownContent;
	
	@Column(columnDefinition = "VARCHAR(500) COMMENT '引用来源'")
	private String reference;
	
	@Column(columnDefinition = "TINYINT UNSIGNED COMMENT '是否启用。0：false，1：true'", nullable = false)
	private Boolean enabled;
	
	@Column(columnDefinition = "TINYINT UNSIGNED COMMENT '是否是公开的。0：false，1：true'", nullable = false)
	private Boolean publicly;
	
	@Column(columnDefinition = "TINYINT UNSIGNED COMMENT '是否渲染目录。0：false，1：true'", nullable = false)
	private Boolean toc;
	
	@Column(columnDefinition = "INT UNSIGNED COMMENT 'version'", nullable = false)
	private Integer version;
	
	@Column(columnDefinition = "INT UNSIGNED COMMENT '浏览次数'")
	private Integer views;
	
	@JsonIgnore
	@Column(name = "deleted", columnDefinition = "BIGINT UNSIGNED COMMENT '是否删除。0：未删除，非0：删除时间戳'", nullable = false)
	private Long deleted;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'", nullable = false)
	private LocalDateTime createAt;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT NULL COMMENT '修改时间'")
	private LocalDateTime updateAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getMarkdownContent() {
		return markdownContent;
	}

	public void setMarkdownContent(String markdownContent) {
		this.markdownContent = markdownContent;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getPublicly() {
		return publicly;
	}

	public void setPublicly(Boolean publicly) {
		this.publicly = publicly;
	}

	public Boolean getToc() {
		return toc;
	}

	public void setToc(Boolean toc) {
		this.toc = toc;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Long getDeleted() {
		return deleted;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}	
}