import java.util.*;

public class Main{
    public static void main(String[] arts){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 20);
        map.put("c", 10);
        map.put("b", 30);
        System.out.println(map.keySet());
    }
}

// [a, c, b]
