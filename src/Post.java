import java.util.ArrayList;
import org.json.simple.*;

public class Post
{
  private String text;
  private int id;
  //private User poster;
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
  
  public boolean addPost(String text, int id)
  {
	Post newpost = new Post(text, id);
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

  public void removeAllNodes()
  {
    // remove other posts
    for(Post node: nodes)
    {
	  node.removeAllNodes();
      nodes.remove(node);
    }
  }
  public JSONObject getChildPosts(String text, int id) 
  {
	  
	  //JSONParser parse = Json.createParser();
	  JSONObject json = new JSONObject();
	  Post returnednode;
	  if(this.getID() == id && this.getText().equals(text)) 
	  {
		  
	  }
	  else 
	  {
		  json = null;
	  }
	  for(Post node : nodes) 
	  {
		if(json != null) 
		{
			json = getChildPosts(text, id);
		}
	  }
	  return json;
  }
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
