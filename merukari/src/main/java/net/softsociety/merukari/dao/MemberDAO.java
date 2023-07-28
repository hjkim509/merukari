package net.softsociety.merukari.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.merukari.domain.Member;


/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {

	int join(Member m);


}
