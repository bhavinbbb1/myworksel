package com.smoketests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
   public static Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

    public static void main(String... arg) {
        // Add data with duplicate keys
        addValues("A", "a1");
        addValues("A", "a2");
        addValues("B", "b");
        addValues("A", "B");
        addValues("B", "C");
        addValues("C", "D");

        // View data.
        printva();
  //      deleteValues("A", "a2");
        System.out.println("------After remove------");
        printva();
        indirectFriends("A");
    }

    private static void addValues(String key, String value) {
        ArrayList tempList = null;
        if (hashMap.containsKey(key)) {
            tempList = hashMap.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        hashMap.put(key, tempList);
    }

    public static void deleteValues(String name1,String name2){
        ArrayList<String> tempList =  hashMap.get(name1);
        tempList.remove(name2);
        hashMap.remove(name1);
        hashMap.put(name1,tempList);

    }

    public static void indirectFriends(String name1){
        ArrayList<String> tempList =  hashMap.get(name1);
        ArrayList<String> indirectFriedtemp=new ArrayList<String>();
        ArrayList<String> IndirectFriends=new ArrayList<String>();
        Iterator it = tempList.iterator();
        while(it.hasNext()) {
            indirectFriedtemp= hashMap.get(it.next().toString());
            if(indirectFriedtemp !=null) {
                Iterator itForIndirect = indirectFriedtemp.iterator();
                while (itForIndirect.hasNext()) {
                    String tempoftemp = itForIndirect.next().toString();
                    IndirectFriends.add(tempoftemp);
                }
            }
        }

        System.out.println("---------------Indirect friedns--------");
        Iterator itm = IndirectFriends.iterator();
        while(itm.hasNext()){
            System.out.println(itm.next().toString());
        }
    }

    public static void printva(){
        Iterator it = hashMap.keySet().iterator();
        ArrayList<String> tempList = null;
        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = hashMap.get(key);
            if (tempList != null) {
                for (String value: tempList) {
                    System.out.println("Key : "+key+ " , Value : "+value);
                }
            }
        }
    }
}
