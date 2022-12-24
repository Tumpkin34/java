package view;

import java.io.IOException;

import dao.NameDAO;
import vo.NameVO;

public class VIew {

	public static void main(String[] args) throws IOException{
		NameDAO dto = new NameDAO();
//		dto.merge();
		dto.merge();
		dto.updateRanking();
		
		

	}

}
