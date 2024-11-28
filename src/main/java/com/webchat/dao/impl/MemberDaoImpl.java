package com.webchat.dao.impl;

import com.webchat.dao.MemberDao;
import com.webchat.mapper.MemberMapper;
import com.webchat.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("memberDao")
@Log4j
public class MemberDaoImpl implements MemberDao {

    private static final Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);

    @Resource(name = "memberMapper")
    private MemberMapper memberMapper;

    //회원 정보 조회
    @Override
    public MemberVo selectMemberId(String id) throws Exception {
        logger.info("=========> MemberDao selectMemberId() 기능 처리");
        return memberMapper.selectMemberId(id);
    }

    //회원 가입
    @Override
    public int insertMember(MemberVo vo) throws Exception {
        logger.info("=========> MemberDao insertMember() 기능 처리");
        return memberMapper.insertMember(vo);
    }
}
