package com.koreait.app.reply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.koreait.app.Execute;
import com.koreait.app.Result;
import com.koreait.app.reply.dao.ReplyDAO;
import com.koreait.app.reply.vo.ReplyVO;

public class ListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		ReplyDAO replyDAO = new ReplyDAO();
		ReplyVO replyVO = new ReplyVO();
		PrintWriter out = resp.getWriter();
		
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		JSONArray replies = new JSONArray();
		System.out.println(replyDAO.selectAll(boardNumber));
		replyDAO.selectAll(boardNumber).forEach(replyDTO -> {JSONObject reply = new JSONObject(replyDTO); replies.put(reply);});
		System.out.println(replies);
		
		out.print(replies);
		out.close();
		System.out.println(boardNumber);
		
		return null;
	}

}
