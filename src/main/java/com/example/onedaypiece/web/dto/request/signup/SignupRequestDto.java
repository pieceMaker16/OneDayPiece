package com.example.onedaypiece.web.dto.request.signup;

import com.example.onedaypiece.exception.ApiRequestException;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SignupRequestDto {

    private String email;
    private String nickname;
    private String password;
    private String passwordConfirm;
    private String profileImg;


    public SignupRequestDto(String email,  String password, String nickname, String passwordConfirm,
                            String profileImg){

        if(email == null || email.isEmpty()) {
            throw new ApiRequestException("email(ID)를 입력해주세요");
        }

        // email형식인지 확인하는 정규식 넣기
        if(!email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")){
            throw new ApiRequestException("올바른 이메일 형식이 아닙니다.");
        }

        if(password == null || passwordConfirm == null){
            throw new ApiRequestException("패스워드가 null이므로 입력해 주세요.");
        }

        if(password.isEmpty() || passwordConfirm.isEmpty()) {
            throw new ApiRequestException("패스워드를 입력해 주세요.");
        }

        if(password.length() < 4 || password.length() > 20) {
            throw new ApiRequestException("비밀번호는  4~20자리를 사용해야 합니다.");
        }

        if ( !(password.equals(passwordConfirm))){
            throw new ApiRequestException("비밀번호가 서로같지않습니다.");
        }

        if(nickname == null || nickname.isEmpty()){
            throw new ApiRequestException("닉네임을 입력해주세요");
        }


        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.profileImg = profileImg;
    }
}
