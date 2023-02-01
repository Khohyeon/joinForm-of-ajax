package shop.mtcoding.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.ajax.dto.ResponseDto;

@Controller
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @GetMapping("/user/usernameSameCheck")
    public @ResponseBody ResponseDto<?> check(String username) {
        if (username == null || username.isEmpty()) {
            return new ResponseDto<>(-1, "username 쿼리스트링을 전달해주세요..", null);
        }
        if (username.equals("ssar")) { // db에 있음
            return new ResponseDto<>(1, "동일한 username이 존재합니다.", false);
        } else {
            return new ResponseDto<>(1, "해당 username으로 회원가입이 가능합니다.", true);
        }
    }
}
