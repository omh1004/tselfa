package com.mh.tselfa.member.model.Entity;





import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

import com.mh.tselfa.member.model.dto.User;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserEntity {

    @Id
    @Column(name = "instructor_code", length = 30, nullable = false)
    private String instCode;

    @Column(name = "id", length = 20)
    private String userId;

    @Column(name = "password", length = 20)
    private String pwd;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "nickname", length = 20)
    private String nick;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phone;

    @Column(name = "join_date")
    private LocalDate joinDt;

    @Column(name = "last_login_date")
    private LocalDate loginDt;

    @Column(name = "withdrawal_date")
    private LocalDate wdDt;

    // Entity -> DTO 변환 메소드
    public User toDTO() {
        return User.builder()
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

    // DTO -> Entity 변환 정적 메소드
    public static UserEntity fromDTO(User dto) {
        return UserEntity.builder()
                .instCode(dto.getInstCode())
                .userId(dto.getUserId())
                .pwd(dto.getPwd())
                .name(dto.getName())
                .nick(dto.getNick())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .joinDt(dto.getJoinDt())
                .loginDt(dto.getLoginDt())
                .wdDt(dto.getWdDt())
                .build();
    }
}

