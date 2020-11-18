package felling.cosmo.classes;

import felling.cosmo.CosmoFelling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class FellingTypes {
    LinkedHashMap<String, Integer> a = new LinkedHashMap<String, Integer>();
    String value;
    public FellingTypes(String typename){
        if(CosmoFelling.INSTANCE.getConfig().contains("종류."+typename+".데이터")){
            List<String> alpha = CosmoFelling.INSTANCE.getConfig().getStringList("종류."+typename+".데이터");
            for(String s : alpha){
                try{
                    String[] a = s.split(":");
                    this.a.put(a[0], Integer.parseInt(a[1]));
                }catch(Exception e){
                    System.out.println(typename+" 타입 로드 중 오류 발생!");
                }
            }
        }
        if(CosmoFelling.INSTANCE.getConfig().contains("종류."+typename+".완성시붙일세메틱")){
            this.value = CosmoFelling.INSTANCE.getConfig().getString("종류."+typename+".완성시붙일세메틱");
        }
    }
    public LinkedHashMap<String, Integer> clonedMap(){
        return new LinkedHashMap<String, Integer>(a);
    }
    public String getFinish(){
        return name;
    }
}
