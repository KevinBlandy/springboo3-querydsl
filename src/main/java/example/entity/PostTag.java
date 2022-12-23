package example.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "post_tag", indexes = { @Index(columnList = "tag_id", name = "tag_id") })
@org.hibernate.annotations.Table(appliesTo = "post_tag", comment = "帖子 - 标签")
@IdClass(PostTag.Id.class)
public class PostTag {

	@javax.persistence.Id
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "post_id", columnDefinition = "BIGINT UNSIGNED COMMENT '帖子ID'")
	private Long postId;

	@javax.persistence.Id
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "tag_id", columnDefinition = "BIGINT UNSIGNED COMMENT '标签ID'")
	private Long tagId;

	@Column(columnDefinition = "INT COMMENT '排序'")
	private Integer sort;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public static class Id implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2891699814624985887L;
		private Long postId;
		private Long tagId;

		public Id(Long postId, Long tagId) {
			super();
			this.postId = postId;
			this.tagId = tagId;
		}

		public Id() {
			super();
		}

		public Long getPostId() {
			return postId;
		}

		public void setPostId(Long postId) {
			this.postId = postId;
		}

		public Long getTagId() {
			return tagId;
		}

		public void setTagId(Long tagId) {
			this.tagId = tagId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(postId, tagId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			return Objects.equals(postId, other.postId) && Objects.equals(tagId, other.tagId);
		}
	}
}
