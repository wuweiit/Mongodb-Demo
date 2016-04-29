package mongodb;

/**
 *  
 *  吴伟 版权所有
 */

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wuweiit.domain.User;

/**
 * Mongodb 保存数据操作
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
public class MongoSaveTest {

	@Autowired
	private MongoTemplate mongo;

	/**
	 * MongoTempate.save()操作，将根据Id覆盖原来的数据。
	 */
	@Test
	public void testSave() throws Exception {

		User user = new User();
		user.setAge(11);
		user.setBirthday(new Date());
		user.setName("zhang san");
		user.setIntroduce("ceshgid ");

		mongo.save(user);
	}

	
	
	/**
	 * MongoTempate.insert()操作实现的 insert操作, 如果数据id存在，不会做任何操作。
	 */
	@Test
	public void testInsert() throws Exception {
		User user = new User();
		user.setId(2);
		user.setAge(11);
		user.setBirthday(new Date());
		user.setName("zhang san2");
		user.setIntroduce("ceshgi2");

		mongo.insert(user);

	}
}
