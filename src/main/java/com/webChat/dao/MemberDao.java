package com.webChat.dao;

import com.webChat.vo.MemberVo;

public interface MemberDao {

    //회원 정보 조회
    MemberVo selectMemberId(MemberVo vo) throws Exception;

    //회원 가입
    int insertMember(MemberVo vo) throws Exception;
}
