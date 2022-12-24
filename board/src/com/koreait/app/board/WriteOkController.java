package com.koreait.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Execute;
import com.koreait.app.Result;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.vo.BoardVO;

public class WriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO boardVO = new BoardVO();
		Result result = new Result();
		
		boardVO.setMemberNumber((Integer)req.getSession().getAttribute("memberNumber"));
		boardVO.setBoardTitle(req.getParameter("boardTitle"));
		boardVO.setBoardContent(req.getParameter("boardContent"));
		
		boardDAO.insert(boardVO);
		
		result.setPath("/board/listOk.bo");
		
		return result;
	}

}
