package net.softsociety.merukari.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.merukari.domain.Board;


/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class Board1Controller {
	
	@Autowired
	BoardService service;
	
	@GetMapping("main")
	public String main(Model model) {
		ArrayList<Board> list = service.boardList();
		log.debug("판매 정보 게시판 리스트 : {}", list);
		model.addAttribute(list);
		return "view/boardMain";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "view/boardWrite";
	}
	
	@PostMapping("insert")
	public String insert(
			@AuthenticationPrincipal UserDetails user,
			Board board) {
		board.setMemberid(user.getUsername());
		service.boardInsert(board);
		return "redirect:/board/main";
	}
	
	@GetMapping("read")
	public String read(
			@AuthenticationPrincipal UserDetails user,
			@RequestParam(name="boardnum", defaultValue="0") int boardnum,
			Model model) {
		Board board = service.boardRead(boardnum);
		
		if(board == null) {
			return "redirect:/view/boardMain";
		}
		
		log.debug("판매 정보 확인 : {}", board);
		model.addAttribute("board", board);
		
		return "view/boardRead";
	}
	
	@GetMapping("delete")
	public String delete(
			@AuthenticationPrincipal UserDetails user,
			@RequestParam(name="boardnum", defaultValue = "0") int boardnum
			) {
		
		Board board = new Board();
		
		board.setBoardnum(boardnum);
		board.setMemberid(user.getUsername());
		
		service.boardDelete(board);
		
		return "redirect:main";
	}
	
	@GetMapping("buyItem")
	public String butItem(
			@AuthenticationPrincipal UserDetails user,
			@RequestParam(name="boardnum", defaultValue = "0") int boardnum
			)
	
		Board board = new board();
		
		board.setBoardnum(boardnum);
		board.setBuyerid(user.getUsername());
		
		int n = service.buyItem(board);
		if(n == 0) {
			return "board/deleteError";
		}
	
		return "redirect:main";
	
}
