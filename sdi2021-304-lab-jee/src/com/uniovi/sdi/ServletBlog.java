package com.uniovi.sdi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletBlog
 */
@WebServlet("/ServletBlog")
public class ServletBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBlog() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Post> posts = new BlogPostsService().getPosts();
		

		session.setAttribute("postsList", posts);
		getServletContext().getRequestDispatcher("/blog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String text= request.getParameter("text");
		
		Post	post	=	new Post(name, title, text);

		BlogPostsService bp = new BlogPostsService();
		bp.getPosts();
		bp.setNuevoPost(post);
		
		
		doGet(request, response);

	}

}
