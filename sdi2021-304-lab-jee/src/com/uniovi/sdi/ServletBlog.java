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
		// TODO Auto-generated constructor stub
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

	private void insertarPostsList(List<Post> posts, Post post) {
		
		if (!posts.contains(post)) {
			posts.add(post);
		}
		
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
		bp.setNuevoPost(post);

		doGet(request, response);

	}

}
