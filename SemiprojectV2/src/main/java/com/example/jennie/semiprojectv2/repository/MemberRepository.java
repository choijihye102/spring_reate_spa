package com.example.jennie.semiprojectv2.repository;
;
import com.example.jennie.semiprojectv2.domain.Member;
import com.example.jennie.semiprojectv2.domain.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {

    @Insert("insert into members (userid,passwd,name,email) values (#{userid},#{passwd},#{name},#{email})")
    int insertMember(MemberDTO member) ;


    @Select("select count(*) from members where userid = #{userid}")
    int countByUserid(String userid);

    @Select("select count(*) from members where email = #{email}")
    int countByEmail(String email);

    @Select("select * from members where userid = #{userid}")
    Member findByUserid(String userid);

}
