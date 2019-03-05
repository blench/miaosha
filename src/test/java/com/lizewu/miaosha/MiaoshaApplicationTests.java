package com.lizewu.miaosha;

import com.lizewu.miaosha.dao.UserDOMapper;
import com.lizewu.miaosha.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lizewu.miaosha.dao")
public class MiaoshaApplicationTests {

	@Autowired
	private UserDOMapper userDOMapper;
	@Test
	public void contextLoads() {
		UserDO userDO = userDOMapper.selectByPrimaryKey(1);
	}

}
