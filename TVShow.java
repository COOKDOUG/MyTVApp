/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytvapp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author cookd
 */
public class TVShow {
    private String showName;
    private int season;
    private int episodeNumber;
    
    // allTVShows, episodeArray, episodesPerSeason, and showInformation all belong in another class.
    private LinkedList<String> allTVShows;
    private ArrayList<Integer> episodeArray;
    private HashMap<Integer, ArrayList<Integer>> episodesPerSeason;
    /*
    The following sets up the show information.  
    The key is a TV Show title (ie "Friends").
    The key is associated with a hashmap of seasons(Integer) to episodes available in the season (ArrayList<Integer>).    
    */
    private HashMap<String, HashMap<Integer, ArrayList<Integer>>> showInformation; 
    
    public TVShow(String incTitle, int incSeason, int incEpisodeNumber){
        showName = incTitle;
        season = incSeason;
        episodeNumber = incEpisodeNumber;
        
        //Clear previous HashMaps
        episodeArray.clear();
        episodesPerSeason.clear();
        
        // Use switch statements instead?  - Could clean up code.
        // Put as it's own function?  - Doesn't belong in the creation of a TV Show.
        if (!allTVShows.isEmpty()){
            if(allTVShows.contains(showName)){
                episodesPerSeason = showInformation.get(showName);
                if (episodesPerSeason.containsKey(season)){
                    episodeArray = episodesPerSeason.get(season);
                    if (episodeArray.contains(episodeNumber)){
                        //Do nothing (the episode in this season of this show already exists.)
                    } else {
                        // This episode for this season of this show does not exist (update everything).
                        updateShowInformation();
                    }
                } else {
                    // This season of this show does not exist (update everything).
                    updateShowInformation();
                }
            } else {
                // This show does not exist (update everything).
                allTVShows.add(showName);
                updateShowInformation();
            }
        } else {
            allTVShows.add(showName);
            updateShowInformation();
        }
    }
    private void updateShowInformation(){
        episodeArray.add(episodeNumber);
        episodesPerSeason.put(season, episodeArray);
        showInformation.put(showName, episodesPerSeason);
    }
}