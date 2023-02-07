package com.jw.teammakter.domain.v2;

import java.util.ArrayList;
import java.util.List;

public class PositionGroup {

    private List<PlayerV2> topGroup = new ArrayList<>();
    private List<PlayerV2> jungleGroup = new ArrayList<>();
    private List<PlayerV2> apGroup = new ArrayList<>();
    private List<PlayerV2> adGroup = new ArrayList<>();
    private List<PlayerV2> supGroup = new ArrayList<>();
    private List<PlayerV2> allGroup = new ArrayList<>();

    public void addTopGroup(PlayerV2 player){
        topGroup.add(player);
    }
    public void addJungleGroup(PlayerV2 player){
        jungleGroup.add(player);
    }
    public void addApGroup(PlayerV2 player){
        apGroup.add(player);
    }
    public void addAdGroup(PlayerV2 player){
        adGroup.add(player);
    }
    public void addSupGroup(PlayerV2 player){
        supGroup.add(player);
    }
    public void addAllGroup(PlayerV2 player){
        allGroup.add(player);
    }

    public List<PlayerV2> getTopGroup() {
        return topGroup;
    }

    public List<PlayerV2> getJungleGroup() {
        return jungleGroup;
    }

    public List<PlayerV2> getApGroup() {
        return apGroup;
    }

    public List<PlayerV2> getAdGroup() {
        return adGroup;
    }

    public List<PlayerV2> getSupGroup() {
        return supGroup;
    }

    public List<PlayerV2> getAllGroup() {
        return allGroup;
    }
}
