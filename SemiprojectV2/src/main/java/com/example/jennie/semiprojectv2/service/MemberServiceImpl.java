package com.example.jennie.semiprojectv2.service;

import com.example.jennie.semiprojectv2.domain.MemberDTO;
import com.example.jennie.semiprojectv2.repository.MemberRepository;
import com.example.jennie.semiprojectv2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

        private final MemberRepository memberMapper;

        public boolean newMember(MemberDTO member) {

                // 아이디 중복 체크
                if (memberMapper.countByUserid(member.getUserid()) > 0) {
                        throw new IllegalStateException("Service에서 호출 => 이미 존재하는 아이디입니다 ");
                }

                // 이메일 중복 체크
                if (memberMapper.countByEmail(member.getEmail()) > 0) {
                        throw new IllegalStateException("Service에서 호출 => 이미 존재하는 이메일입니다 ");
                }

                int result = memberMapper.insertMember(member);
                return result == 1; // 회원정보가 테이블 저장되었는지 여부에 따라 True/False 반환.

        }


}



