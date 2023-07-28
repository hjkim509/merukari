package net.softsociety.merukari.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.merukari.dao.BoardDAO;
import net.softsociety.merukari.domain.Board;


@Transactional
@Service
public class Board1SeviceImpl implements Board1Service {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public ArrayList<Board> boardList() {
		return dao.boardList();
	}

	@Override
	public int boardInsert(Board board) {
		return dao.boardInsert(board);
	}

	@Override
	public Board boardRead(int boardnum) {
		return dao.boardRead(boardnum);
	}

	@Override
	public int boardDelete(Board board) {
		return dao.boardDelete(board);
	}

	@Override
	public int buyItem(Board board) {
		return dao.boardPurchase(board);
	}
	
	
}
