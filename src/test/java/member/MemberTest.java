package member;

import com.webchat.dao.MemberDao;
import com.webchat.vo.MemberVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml","file:resources/spring/*.xml"})
public class MemberTest {

    @Resource(name = "memberDao")
    private MemberDao memberDao;

    //회원 등록
    @Test
    public void insertMember() throws Exception{
        MemberVo memberVo = new MemberVo();

        memberVo.setId("test1");
        memberVo.setPw("1111");

        memberDao.insertMember(memberVo);

        System.out.println(memberVo);
    }

    //회원 조회
    @Test
    public void selectMemberId() throws Exception{
        System.out.println(memberDao.selectMemberId("test1"));

    }
}
