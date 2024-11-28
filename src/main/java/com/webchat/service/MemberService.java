package com.webchat.service;

import com.webchat.vo.MemberVo;

public interface MemberService {

    //회원 정보 조회
    MemberVo selectMemberId(String id) throws Exception;

    //회원 가입
    int insertMember(MemberVo vo) throws Exception;
}
