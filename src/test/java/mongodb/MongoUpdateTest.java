package mongodb;

/**
 *  
 *  吴伟 版权所有
 */

import java.util.Date;

import org.eclipse.jdt.internal.core.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wuweiit.domain.User;

/**
 * Mongodb 更新数据操作
 * 
 * @author marker
 * @date 2015-08-01 上午9:47:26
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
// @Transactional(isolation=Isolation.READ_UNCOMMITTED) /* 配置未提交读事务 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mongo.xml" })
public class MongoUpdateTest {

	@Autowired
	private MongoTemplate mongo;

	/**
	 * MongoTempate.save()操作，将根据Id覆盖原来的数据。
	 */
	@Test
	public void testUpdate() throws Exception {
 
		// 将用户id为1的数据，更新name为李四，只更新查询出来的第一条数据
		
		// 如果没有查询出数据，不产生异常。
		
		mongo.updateFirst(Query.query(Criteria.where("id").is(2)), 
				Update.update("name", "李四2"), User.class);
		
		// 会将第一条数据更新了（排序为id顺序）
		mongo.updateFirst(null, 
				Update.update("name", "李四"), User.class);
		
		// 所有age + 10岁 
		// inc 加操作，减法操作负数
		// （更多参考:http://docs.spring.io/spring-data/data-mongo/docs/1.8.4.RELEASE/reference/html/#mongo-template.save-insert）
		mongo.updateMulti(null, new Update().inc("age", -1), 
				User.class);
		
		// 删除操作
		mongo.remove(Query.query(Criteria.where("id").is(2)), User.class);
		
		// 查询数据条数
		long count = mongo.count(null, User.class);
		System.out.println(count);
	}

	
}
