package facehack;

import java.util.Hashtable;

public class User
{
  private String username;
  private String imagePath;
  public Hashtable<Integer, Post> listofPosts = new Hashtable<Integer, Post>();

  public User(String username, String imagePath)
  {
    this.username = username;
    this.imagePath = imagePath;
  }

  public String getName()
  {
    return this.username;
  }

  public String getimagePath()
  {
    return this.imagePath;
  }

  public void addPosttoListofPosts(int ID, Post post)
  {
    listofPosts.put(ID, post);
  }

  public void setName(String name)
  {
    this.username = name;
  }
  public void setImagepath()
  {
    this.imagePath = imagePath;
  }

}
