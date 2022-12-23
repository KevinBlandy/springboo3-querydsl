package example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "tag", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }, name = "title") })
@org.hibernate.annotations.Table(appliesTo = "tag", comment = "帖子标签")
public class Tag {

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(columnDefinition = "BIGINT UNSIGNED COMMENT 'ID'")
	private Long id;

	@Column(columnDefinition = "VARCHAR(500) COMMENT '名称'", nullable = false)
	private String title;

	@Column(columnDefinition = "VARCHAR(50) COMMENT 'path'", nullable = false)
	private String path;

	@Column(columnDefinition = "VARCHAR(100) COMMENT '图标'")
	private String icon;

	@Column(columnDefinition = "VARCHAR(500) COMMENT '介绍'")
	private String instruction;

	@Column(columnDefinition = "TINYINT UNSIGNED COMMENT '是否启用。0：禁用，1：启用'", nullable = false)
	private Boolean enabled;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
