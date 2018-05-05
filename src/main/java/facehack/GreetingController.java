package facehack;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

@RestController
public class GreetingController {

    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="message", defaultValue="None") String message) {
    	String array[] = message.split(":");
    	
    	JSONObject obj = new JSONObject();
        obj.put("id", new Integer(counter.incrementAndGet()));
        obj.put("name", array[0]);
        obj.put("message", array[1]);
        
        JSONObject obj2 = new JSONObject();
        obj2.put("id", new Integer(counter.get()));
        obj2.put("name", array[0]);
        obj2.put("message", array[1]);
        
        String name = (String) obj2.get("name");
        String msg = (String) obj2.get("message");
        String returnmsg = name+": "+msg;
        
        return returnmsg;
        
      
        
        
        
        		
    	
    	
        //return new Greeting(counter.incrementAndGet(), array[0], array[1]);
    }
}
