package net.softsociety.merukari.service;

import java.util.ArrayList;
import java.util.HashMap;

import net.softsociety.merukari.domain.Board;

public interface Board1Service {

	public ArrayList<Board> boardList();
	
	public int boardInsert(Board board);
	
	public Board boardRead(int boardnum);
	
	public int boardDelete(Board board);
	
	public int buyItem(Board board);
}
