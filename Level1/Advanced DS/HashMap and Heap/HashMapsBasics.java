import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
public class Main{
    public static void main(String args[]){
        HashMap<String,Integer> hm = new HashMap<>();
        
        hm.put("India",200);
        hm.put("UK",180);
        hm.put("USA",190);
        hm.put("China",170);
        hm.put("Utopia",150);

        System.out.println(hm);
        hm.put("India",220);
        hm.put("Nigeria",220);
        System.out.println(hm);
        
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Nepal"));
        
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove("Nepal"));

        System.out.println(hm);

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Nepal"));

        System.out.println(hm.size());
        
        Set <String> set = hm.keySet();
        System.out.println(set);

        ArrayList<String> list = new ArrayList<>(hm.keySet());
        System.out.println(list);
        
        for(String key : hm.keySet()){
            System.out.println(key + "-->" + hm.get(key));
        }
        
    }
}
