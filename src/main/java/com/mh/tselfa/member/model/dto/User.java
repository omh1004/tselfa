package com.mh.tselfa.member.model.dto;



import java.time.LocalDate;

import lombok.*;

import com.mh.tselfa.member.model.Entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class User {

    private String instCode;
    private String userId;
    private String pwd;
    private String name;
    private String nick;
    private String email;
    private String phone;
    private LocalDate joinDt;
    private LocalDate loginDt;
    private LocalDate wdDt;

    // Entity -> DTO 변환 메소드
    public static User fromEntity(UserEntity entity) {
        return User.builder()
                .instCode(entity.getInstCode())
                .userId(entity.getUserId())
                .pwd(entity.getPwd())
                .name(entity.getName())
                .nick(entity.getNick())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .joinDt(entity.getJoinDt())
                .loginDt(entity.getLoginDt())
                .wdDt(entity.getWdDt())
                .build();
    }

    // DTO -> Entity 변환 메소드
    public UserEntity toEntity() {
        return UserEntity.builder()
                .instCode(this.instCode)
                .userId(this.userId)
                .pwd(this.pwd)
                .name(this.name)
                .nick(this.nick)
                .email(this.email)
                .phone(this.phone)
                .joinDt(this.joinDt)
                .loginDt(this.loginDt)
                .wdDt(this.wdDt)
                .build();
    }
}