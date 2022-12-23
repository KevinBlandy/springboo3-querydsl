package example.text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import example.ExampleApplication;
import example.entity.QPost;
import example.entity.QPostTag;
import example.entity.QTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleApplicationTest {
	
	private static final Logger log = LoggerFactory.getLogger(ExampleApplicationTest.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
@Test
@Transactional(readOnly = true)
public void test () {
	var tag = QTag.tag;
	var postTag = QPostTag.postTag;
	var post = QPost.post;
	
	var query = new JPAQueryFactory(this.entityManager);
	
	SimpleExpression<Long> postCount = Expressions.as(JPAExpressions
				.select(Expressions.ONE.count())
				.from(postTag)
				.innerJoin(post).on(post.id.eq(postTag.postId))
				.where(postTag.tagId.eq(tag.id)
					.and(post.enabled.eq(true)	
					.and(post.deleted.eq(0L))) 
				)
		, "post_count");
	
	var tuple = query.select(tag.id, tag.title, tag.icon, tag.instruction, tag.enabled, tag.path, postCount)
			.from(tag)
			.where(tag.id.eq(10000L))
			.fetchOne();
	
	log.info("tuple:{}", tuple);
}
	
}
