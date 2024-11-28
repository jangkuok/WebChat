package redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml","file:resources/spring/*.xml"})
public class RedisConnectionTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    @Test
    public void redisTest() throws Exception{
        for (int i = 0; i < 10; i++) {
            redisTemplate.convertAndSend(channelTopic.getTopic(), "message " + i);
            Thread.sleep(1000);
        }
        Thread.sleep(5000);
    }
}
