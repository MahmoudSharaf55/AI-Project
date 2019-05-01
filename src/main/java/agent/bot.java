package agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class bot extends Agent {
    JSONObject request;
    String response;
    JSONObject jsonObject;

    @Override
    protected void setup() {
        super.setup();
        System.out.println("Bot is ready");
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src\\main\\resources\\chat.json"));
            jsonObject = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        addBehaviour(new recieveTick());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("Bot is takeDown");
    }

    class recieveTick extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl = getAgent().receive();
            if (acl != null) {
                System.out.println("User : " + acl.getContent());
                request = (JSONObject) jsonObject.get(acl.getContent());
                if (request != null){
                    response = (String) request.get("response_1");
                    System.out.println("Bot : "+response);
                } else{
                    System.out.println("Bot : "+"مش فاهم");
                }
            }
        }
    }
}