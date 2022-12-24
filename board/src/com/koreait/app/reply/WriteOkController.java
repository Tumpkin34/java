package com.koreait.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Execute;
import com.koreait.app.Result;
import com.koreait.app.reply.dao.ReplyDAO;
import com.koreait.app.reply.vo.ReplyVO;

public class WriteOkController extends Result implements Execute {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String replyContent = req.getParameter("replyContent");
		int memberNumber =Integer.valueOf(req.getParameter("memberNumber"));
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		
		
		System.out.println(replyContent);
		System.out.println(memberNumber);
		System.out.println(boardNumber);
		
		replyVO.setReplyContent(replyContent);
		replyVO.setBoardNumber(boardNumber);
		replyVO.setMemberNumber(memberNumber);
		System.out.println(replyVO);
		replyDAO.insert(replyVO);
		
		return null;
	}

}
