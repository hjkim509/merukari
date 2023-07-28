package net.softsociety.merukari.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.merukari.domain.Board;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {
	//판매정보 게시판, 판매글 목록 출력 메서드
	ArrayList<Board> boardList();
	
	//판매글 쓰기 페이지에서 작성한 판매글 정보를 실제 board 테이블에 insert하는 메서드
	int boardInsert(Board board);
	
	//판매글 하나를 선택해서 해당 판매글의 정보를 출력하는 메서드
	Board boardRead(int boardnum);
	
	//구매하기 버튼을 눌렀을때 해당 게시글의 soldout을 Y로 바꾸고
	//구매자 id에 해당 버튼을 클릭한 유저의 id를 집어넣는 update 메서드
	int boardPurchase(Board board);
	
	//삭제를 누르면 boardnum과 memberid정보를 가져가서 해당 게시글의 작성자가 맞는지 확인한 후,
	//게시글작성자가 맞을경우 해당 게시글을 삭제하는 메서드
	int boardDelete(Board board);
	
	//카테고리, 제목을 검색하여 해당 하는 게시글들만 목록으로 출력하는 메서드
	ArrayList<Board> boardSearch(Board board);
}
