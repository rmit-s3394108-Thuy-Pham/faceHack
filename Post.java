import java.util.ArrayList;

public class Post
{
  private String text;
  private int id;
  private User poster;
  private String imageurl;
  private ArrayList<Post> nodes = new ArrayList<Post>();
  public Post(String text, int id)
  {
    this.text = text;
    this.id = id;
  }
  public String getText()
  {
    return this.text;
  }
  public int getID()
  {
    return this.id;
  }
  public User getPoster()
  {
    return this.poster;
  }
  public boolean addPost(Post newpost)
  {
    if(!this.nodes.contains(newpost))
    {
      this.nodes.add(newpost);
      return true;
    }
    return false;
  }

  public Post getPost(int id)
  {
    for (Post node : nodes)
    {
      if(node.getID() == id)
      {
        return node;
      }
    }
    return null;
  }

//   public boolean removeAllNodes()
//   {
//     // remove other posts
//     for(Post node: nodes)
//     {
// node.removeAllNodes();
//       nodes.remove(node);
//     }
//   }
  /*public boolean removeSpecificNode(int id)
  {
    for(Post node: nodes)
    {
      boolean deleted = node.removeSpecificNode(id);
      if(deleted)
      {
        return true;
      }
    }
    if(this.getID() == id)
    {

    }
  }*/
}
