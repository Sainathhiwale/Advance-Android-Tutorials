package com.dorvis.daggersample;

import java.util.ArrayList;

public class MemberDataManager {
    private String memberStatus;
    private ArrayList<Members> members = new ArrayList<>();

    public MemberDataManager() {
        populateData();
    }

    public String checkMemberStatus(String userInput){
        memberStatus = "Access Denied";
        for (Members m : members){
            if (m.getMemberId().equals(userInput)){
                memberStatus = "Access Granted";
            }
        }
        return memberStatus;
    }

    private void populateData() {
        members.add(new Members("123","Tom","tom@gmail.com"));
        members.add(new Members("127","Sam","sam@gmail.com"));
        members.add(new Members("3","Jack","jack@gmail.com"));
        members.add(new Members("4","Frank","frank@gmail.com"));
        members.add(new Members("5","Mary","mary@gmail.com"));
        members.add(new Members("6","Sara","sara@gmail.com"));
        members.add(new Members("1","Nora","nora@gmail.com"));
        members.add(new Members("2","Jhon","Jhon@gmail.com"));
    }
}
