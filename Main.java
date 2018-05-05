public class Main
{
	public static void main(String[] args)
	{
		Post post1 = new Post("I am", 0);
		Post post2 = new Post("Hackathon", 1);
		Post post3 = new Post("2018", 2);
		User user1 = new User("Jack", "imageurl");
		User user2 = new User("Thuy", "imageurl of user2");
		System.out.println(user1.getName());
		System.out.println(user2.getimagePath());
		user1.addPosttoListofPosts(1, post1);
		user1.addPosttoListofPosts(2, post2);
		user1.addPosttoListofPosts(3, post3);
		user2.addPosttoListofPosts(1, post3);
		System.out.println(user1.getPostHistory());
		System.out.println(user2.getPostHistory());
	}
}
