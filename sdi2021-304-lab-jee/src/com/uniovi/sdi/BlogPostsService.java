package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class BlogPostsService {
	
	public List<Post> getPosts() {
		List<Post> posts = new LinkedList<Post>();
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdPosts");
			List<Post> respuesta = db.queryByExample(Post.class);
			//	NO	RETORNAR	LA	MISMA	LISTA	DE	LA	RESPUESTA
			posts.addAll(respuesta);
		} finally {
			db.close();
		}
		return posts;
	}

	public void setNuevoPost(Post nuevoPost) {
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdPosts");
			db.store(nuevoPost);
			db.commit();
		} finally {
			db.close();

		}
	}

}
