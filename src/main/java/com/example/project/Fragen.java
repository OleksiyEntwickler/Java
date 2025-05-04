package com.example.project;

import java.util.HashMap;
import java.util.Map;

public class Fragen {
    
    Map<String, String> map = new HashMap<>();    

        public void save(String frage, String email){
        map.put(frage, email);
        FileHandler.write(frage, email);
    }
}
