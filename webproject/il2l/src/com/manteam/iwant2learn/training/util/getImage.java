package com.manteam.iwant2learn.training.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.controller.TrainingController;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;

/**
 * Servlet implementation class getImage
 */
public class getImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getImage() {
		super();
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int id = Integer.parseInt(req.getParameter("imageId"));
		String id = req.getParameter("imageId");
		TrainingController trainingController = new TrainingController();

		try {
			ImageStreamVO imageStreamVO;
			imageStreamVO = trainingController.retrieveImageInfo(id);
			if (imageStreamVO != null) {
				resp.getOutputStream().write(imageStreamVO.getImageByteArray(), 0,imageStreamVO.getImageString().length());
			}
		}catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



/**
 * @throws SystemException 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SystemException {

}


}
