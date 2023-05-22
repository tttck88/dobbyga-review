package com.example.dobbygareview.member.repository;


import com.example.dobbygareview.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Member findByEmailAndPw(String email, String pw);

    Optional<Member> findByEmail(String email);

//    @Query("select m from Member m where m.memberName = :memberName")
//    fun findMember(@Param("memberName")memberName: String): List<Member>
//
//    @Query("select m.memberName from Member m")
//    fun findMemberNameList(): List<String>
//
//    @Query("select m from Member m where m.memberName in :names")
//    fun findByNames(@Param("names") names:Collection<String>): List<Member>
//
//    fun findListByMemberName(memberName: String): List<Member> // 컬렉션
//    fun findMemberByMemberName(memberName: String): Member // 단건
//    fun findOptionalByMemberName(memberName: String): Optional<Member> // 단건 Optional
//
//    fun findAllBy(pageable: org.springframework.data.domain.Pageable): Page<Member>
//
////    @Query(value = "select m from Member m", countQuery = "select count(m) from Member m")
////    fun findAllBy(pageable: org.springframework.data.domain.Pageable): Page<Member>
//
//    @Modifying(clearAutomatically = true)
//    @Query("update Member m set m.memberName = m.memberName")
//    fun bulkUpdate() : Int
}
