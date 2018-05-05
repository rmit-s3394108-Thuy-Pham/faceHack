package facehack;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class CreateController {

    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/create")
    public void greeting(@RequestParam(value="parentid", defaultValue="None") String parentid,
    					 @RequestParam(value="userid", defaultValue="None") String userid,
    					 @RequestParam(value="text", defaultValue="None") String text) throws ParseException{
    	//String array[] = message.split(":");
    	JSONParser pars = new JSONParser();
    	//JSONObject obj3 = (JSONObject) pars.parse(message);
    
    	int id = counter.incrementAndGet();
    	int parentid2 = Integer.parseInt(parentid);
    	int userid2 = Integer.parseInt(userid);

    	Post newPost = new Post(text, id, userid2);
    	//Testing.addToText(text);
    	Testing.addPost(newPost, id, parentid2, userid2);
    	/*
        obj.put("id", new Integer(counter.incrementAndGet()));
        obj.put("name", array[0]);
        obj.put("message", array[1]);
        
        JSONObject obj2 = new JSONObject();
        obj2.put("id", new Integer(counter.get()));
        obj2.put("name", array[0]);
        obj2.put("message", array[1]);
        
        String name = (String) obj2.get("name");
        String msg = (String) obj2.get("message");
        String returnmsg = msg+": "+name;
        */
        //return new Greeting(counter.incrementAndGet(), array[0], array[1]);
    }
}
