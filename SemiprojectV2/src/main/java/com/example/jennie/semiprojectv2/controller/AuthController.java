package com.example.jennie.semiprojectv2.controller;

import com.example.jennie.semiprojectv2.domain.Member;
import com.example.jennie.semiprojectv2.domain.MemberDTO;
import com.example.jennie.semiprojectv2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 교차출처 리소스 공유 CORS
@CrossOrigin(origins ="http://localhost:5173")
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?>  joinok(@RequestBody MemberDTO member) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 내정보 : {}", member);

        try {
            // 정상 처리시 상태코드 200으로 응답
            memberService.newMember(member);
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            //  비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못으로 인한 오류 일때
            //  중복 아이디나 중복 이메일 사용시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace(); // 틀린이유 내부적으로 보이기 위해
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못으로 인한 오류 일때
            e.printStackTrace(); // 틀린이유 내부적으로 보이기 위해
        }

        return response;
    }

    @PostMapping("/signin")
    public ResponseEntity<?>  loginok(@RequestBody MemberDTO member) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 로그인 정보 : {}", member);

        try {
            // 정상 처리시 상태코드 200으로 응답
            Member loginUser = memberService.loginMember(member);
            // 세션 처리
            response = ResponseEntity.ok().build();

        } catch (IllegalStateException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace(); // 틀린이유 내부적으로 보이기 위해
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못으로 인한 오류 일때
            e.printStackTrace(); // 틀린이유 내부적으로 보이기 위해
        }

        return response;

    }

}
