package com.lizewu.miaosha;

import com.lizewu.miaosha.dao.UserDOMapper;
import com.lizewu.miaosha.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages= {"com.lizewu.miaosha"})
@RestController
@MapperScan("com.lizewu.miaosha.dao")
public class MiaoshaApplication {

	@Autowired
	private UserDOMapper userDOMapper;

	@RequestMapping("/")
	public String home()
	{
		UserDO userDO = userDOMapper.selectByPrimaryKey(1);
		if(userDO == null)
		{
			return "用户对象不存在";
		} else {
			return userDO.getName();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MiaoshaApplication.class, args);
	}

}
