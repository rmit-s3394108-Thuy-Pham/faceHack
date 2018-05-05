package facehack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;

import org.json.simple.*;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Post
{
  private String text;
  private int id;
  private int userid;
  private String imageurl;
  private ArrayList<Post> nodes = new ArrayList<Post>();
  private Post currDisplPost;
  private long timestamp;
  public Post(String text, int id, int userid)
  {
    this.text = text;
    this.id = id;
    this.userid = userid;
    this.currDisplPost = this;
    this.timestamp = System.currentTimeMillis();
  }
  public String getText()
  {
    return this.text;
  }
  
  public int getUserID()
  {
    return this.userid;
  }
  
  public String getImageURL() 
  {
	  return this.imageurl;
  }
  public int getID()
  {
    return this.id;
  }
  
  public Post getPost(int id)
  {
	for (Post newpost : nodes)
    {
      if(newpost.getID() == id)
      {
        return nodes.get(id);
      }
    }
    return null;
  }
  public void setText(String text) 
  {
	  this.text = text;
  }
  
  public void setID(int id) 
  {
	  this.id = id;
  }
  
  public void setImageURL(String imageurl) 
  {
	  this.imageurl = imageurl;
  }
  
  public boolean addPost(String text, int id, int userid)
  {
	Post newpost = new Post(text, id, userid);
    if(!this.nodes.contains(newpost))
    {
      this.nodes.add(newpost);
      return true;
    }
    return false;
  }

  public boolean addPost(Post newpost)
  {
    if(!this.nodes.contains(newpost))
    {
      System.out.println(this.nodes.size());
      this.nodes.add(newpost);
      return true;
    }
    return false;
  }
  
  public void removeAllNodes()
  {
	nodes = new ArrayList<Post>();
  }
  @SuppressWarnings("unchecked")
  public JSONObject getChildPosts(int id) 
  {
	  
	  //JSONParser parse = Json.createParser();
	  JSONObject json = new JSONObject();
	  if(this.getID() == id) 
	  {
		  json.put("Post ID", id);
		  json.put("User ID", id);
		  json.put("Text", text);
		  JSONArray jsonarray = new JSONArray();
		  for(Post node : nodes) 
		  {
			  JSONObject jobj = new JSONObject();
			  jobj.put("Post ID", node.getID());
			  jobj.put("User ID", node.getUserID());
			  jobj.put("Text", node.getText());
			  jsonarray.add(jobj);
		  }
		  json.put("Posts", jsonarray);
		  return json;
	  }
	  for(Post node : nodes) 
	  {
		if(json.isEmpty()) 
		{
		  json = node.getChildPosts(id);
		}
	  }
	  return json;
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject toJSONFormat() 
  {
	  JSONObject json = new JSONObject();
	  json.put("ID", this.getID());
	  json.put("Text", this.getText());
	  return json;
  }
  
  public String getReadableDate() 
  {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy, HH:mm");
	  Date resultdate = new Date(this.timestamp);
	  return sdf.format(resultdate);
  }
}
