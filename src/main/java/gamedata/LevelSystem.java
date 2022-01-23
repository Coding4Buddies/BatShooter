/*
    Date: January 24, 2021 
    Created by: MinPen
    Purpose:  A Java Class that Communicates with the JSON file and Insert to the Dictionary ADP to use 
              in creating level system.
*/

package gamedata;

// Import a third party dependency for inserting JSON data to Map
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;  

import java.io.File;
import java.util.Map;
import java.util.stream.Stream;


public class LevelSystem {
    
   // Initialize Needed Variables 
   File fileObj;
   Map<String, Object> level;
           
   // Insert the JSON data to the Map
   public LevelSystem() {
        try {  
           ObjectMapper mapper = new ObjectMapper(); 
           fileObj = new File("data/LevelJSON.json");
           level = mapper.readValue(fileObj, new TypeReference<Map<String, Object>>(){}); 
       } catch (Exception e) {  
           e.printStackTrace();
       }
   }
   
   // Returns the data inside the Level Map
   public Map<String, Object> getLevel() {
       return level;
   }
}
