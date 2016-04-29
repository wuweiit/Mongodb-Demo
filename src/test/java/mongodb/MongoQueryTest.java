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

import com.alibaba.fastjson.JSON;

import cn.wuweiit.domain.User;

/**
 * Mongodb 更新数据操作
 * (参考http://docs.spring.io/spring-data/data-mongo/docs/1.8.4.RELEASE/reference/html/#mongo.query)
 * @author marker
 * @date 2015-08-01 上午9:47:26
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
// @Transactional(isolation=Isolation.READ_UNCOMMITTED) /* 配置未提交读事务 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mongo.xml" })
public class MongoQueryTest {

	@Autowired
	private MongoTemplate mongo;

	/**
	 * MongoTempate查询单条数据。
	 */
	@Test
	public void testUpdate() throws Exception {
		User user = mongo.findOne(Query.query(Criteria.where("id").is(0)), User.class);
		System.out.println(JSON.toJSONString(user));
	}

	
}
