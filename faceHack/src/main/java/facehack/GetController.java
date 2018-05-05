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
public class GetController {

    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/get")
    public String greeting(@RequestParam(value="parentid", defaultValue="None") String parentid) throws ParseException{
    	//String array[] = message.split(":");
    	//message = "{"+message+"}";
    	//JSONParser pars = new JSONParser();
    	//JSONObject obj3 = (JSONObject) pars.parse(message);
    	
    	int parentid2 = Integer.parseInt(parentid);
    	return Testing.getPost(parentid2).getChildPosts(parentid2).toString();
    	
    }
}
