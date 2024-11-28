package com.webchat.mapper;

import com.webchat.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    //회원 정보 조회
    MemberVo selectMemberId(String id) throws Exception;

    //회원 가입
    int insertMember(MemberVo vo) throws Exception;


}
