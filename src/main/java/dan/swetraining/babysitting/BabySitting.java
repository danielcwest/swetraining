package dan.swetraining.babysitting;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class BabySitting {
    
    public Map<String, Integer> m = new HashMap<String,Integer>();

    public BabySitting() {}

    public String whoPaidTheMost(String input) throws NullPointerException
    {
        if(input == null) throw new NullPointerException();
        
        String result = "";
        String[] payments = input.split(",");

        for(int i = 0; i < payments.length; i++){
            String payment = payments[i];
            String[] parts = payment.split("\\$");
            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1]);

            price = m.containsKey(name) ? m.get(name) + price : price;

            m.put(name, price);
        }

        Map.Entry<String, Integer> maxItem = new AbstractMap.SimpleEntry<String, Integer>("", 0);

        for (Map.Entry<String, Integer> set : m.entrySet()) {
            if(set.getValue() > maxItem.getValue()){
                maxItem = set;
            }
        }    

        result = getOutput(maxItem);

        return result;
    }

    private String getOutput(Map.Entry<String,Integer> set){
        return set.getKey() + " $" + set.getValue();
    }
}
