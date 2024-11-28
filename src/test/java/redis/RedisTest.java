package redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml","file:resources/spring/*.xml"})
public class RedisTest {

    @Autowired
    StringRedisTemplate redisTemplate;


    @Test
    public void test(){
        final ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test","test");
        String result = valueOperations.get("test");
        System.out.println(result);
    }
}
