package com.mh.tselfa.member.model.repository;


import com.mh.tselfa.member.model.Entity.UserEntity;
import com.mh.tselfa.member.model.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // 기본 CRUD 메소드는 JpaRepository에서 상속됩니다

    // 추가 메소드가 필요한 경우 여기에 선언
    // 예: 이메일로 사용자 찾기
    User findByEmail(String email);

    // 예: 닉네임으로 사용자 찾기
    User findByNick(String nick);
}