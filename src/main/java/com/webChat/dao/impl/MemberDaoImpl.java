package com.webChat.dao.impl;

import com.webChat.dao.MemberDao;
import com.webChat.mapper.MemberMapper;
import com.webChat.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("memberDao")
@Log4j
public class MemberDaoImpl implements MemberDao {

    @Resource(name = "memberMapper")
    private MemberMapper memberMapper;

    //회원 정보 조회
    @Override
    public MemberVo selectMemberId(MemberVo vo) throws Exception {
        log.info("=========> MemberDao selectMemberId() 기능 처리");
        return memberMapper.selectMemberId(vo);
    }

    //회원 가입
    @Override
    public int insertMember(MemberVo vo) throws Exception {
        log.info("=========> MemberDao insertMember() 기능 처리");
        return memberMapper.insertMember(vo);
    }
}
