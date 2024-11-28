package chatroom;

import com.webchat.dao.ChatRoomDao;
import com.webchat.service.ChatRoomMessageService;
import com.webchat.service.ChatRoomService;
import com.webchat.vo.ChatRoomMessageVo;
import com.webchat.vo.ChatRoomVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/dispatcher-servlet.xml","file:resources/spring/*.xml"})
public class ChatRoom {

    @Resource(name = "chatRoomDao")
    private ChatRoomDao chatRoomDao;

    @Resource(name = "chatRoomService")
    private ChatRoomService chatRoomService;

    @Resource(name = "chatRoomMessageService")
    private ChatRoomMessageService chatRoomMessageService;

    
    //채팅방 생성
    @Test
    public void insertChatRoom() throws Exception{
        ChatRoomVo chatRoomVo = new ChatRoomVo();

        chatRoomVo.changeRoomNo(1);
        chatRoomVo.changeRoomName("우리같이 놀자!!");
        chatRoomVo.changeLeaderId("test1");

        int result = chatRoomDao.insertChatRoom(chatRoomVo);

        System.out.println(result);

    }

    //채팅방 업데이트
    @Test
    public void updateChatRoom() throws Exception{
        ChatRoomVo chatRoomVo = new ChatRoomVo();
        chatRoomVo.changeRoomNo(1);
        chatRoomVo.changeRoomName("모이세요!!");

        chatRoomDao.updateChatRoom(chatRoomVo);
    }

    
    //채팅방 삭제
    @Test
    public void deleteChatRoom() throws Exception{
        chatRoomDao.deleteChatRoom(1);
    }

    //채팅방 조회
    @Test
    public void selectChatRoomList() throws Exception{
        System.out.println(chatRoomDao.selectChatRoomList());
    }

    //특정 채팅방 조회
    @Test
    public void selectChatRoomMessageList() throws Exception{
        System.out.println(chatRoomDao.selectChatRoomMessageList(1));
    }

    //메세지 등록
    @Test
    public void insertChatRoomMessage(){
        ChatRoomMessageVo chatRoomMessageVo = new ChatRoomMessageVo();
        chatRoomMessageVo.changeMessageNo(1);
        chatRoomMessageVo.changeCode("1");
        chatRoomMessageVo.changeId("test2");
        chatRoomMessageVo.changeContent("ㅋㅋㅋㅋㅋㅋ");
        chatRoomMessageVo.changeSendDate("오후 11:05");
        chatRoomMessageVo.changeRoomNo(1);

        chatRoomMessageService.insertChatRoomMessage(chatRoomMessageVo);
    }
}
