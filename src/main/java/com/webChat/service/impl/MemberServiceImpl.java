package com.webChat.service.impl;

import com.webChat.dao.MemberDao;
import com.webChat.service.MemberService;
import com.webChat.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberService")
@Log4j
public class MemberServiceImpl implements MemberService {

    @Resource(name = "memberDao")
    private MemberDao memberDao;

    //회원 정보 조회
    @Override
    public MemberVo selectMemberId(MemberVo vo) throws Exception {
        log.info("=========> MemberServiceImpl selectMemberId() 기능 처리");
        return memberDao.selectMemberId(vo);
    }

    //회원 가입
    @Override
    public int insertMember(MemberVo vo) throws Exception {
        log.info("=========> MemberServiceImpl insertMember() 기능 처리");
        return memberDao.insertMember(vo);
    }
}
