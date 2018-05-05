package facehack;

import java.util.Hashtable;

public class Testing {
	private static String text;;
	private static Hashtable<Integer, Post> table = new Hashtable<>();
	
	public static void addToText(String text) {
		Testing.text += text;
	}
	public static void addPost(Post newPost, int id, int parentID, int userID) {
		table.put(id, newPost);
		if (parentID != -1) {
			table.get(parentID).addPost(newPost);
		}
	}
	public static Post getPost(int id) 
	{
		return Testing.table.get(id);
	}
	public static String getText() {
		return Testing.text;
	}
	public static Hashtable<Integer, Post> getTable()
	{
		return Testing.table;
	}
	
}
