package com.pasture.Bridge;

public class YellThreeTimes implements YellTimes {
    public void yellSomeTimes(String whatToYell){
        System.out.println(whatToYell);
        System.out.println(whatToYell);
        System.out.println(whatToYell);
    }
}
