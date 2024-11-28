package com.webchat.service.impl;

import com.webchat.dao.MemberDao;
import com.webchat.service.MemberService;
import com.webchat.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberService")
@Log4j
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource(name = "memberDao")
    private MemberDao memberDao;

    //회원 정보 조회
    @Override
    public MemberVo selectMemberId(String id) throws Exception {
        logger.info("=========> MemberServiceImpl selectMemberId() 기능 처리");
        return memberDao.selectMemberId(id);
    }

    //회원 가입
    @Override
    public int insertMember(MemberVo vo) throws Exception {
        logger.info("=========> MemberServiceImpl insertMember() 기능 처리");
        return memberDao.insertMember(vo);
    }
}
