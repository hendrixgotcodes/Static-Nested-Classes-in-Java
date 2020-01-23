package com.company;

import java.util.ArrayList;

public class Album
{
    private String name;
    private String artiste;
    public Album(String albumName, String artiste)
    {
        this.name = albumName;
        this.artiste = artiste;
    }
    public static boolean addSong(Track track)
    {
        return songList.addSong(track);
    }
    public Track findSong(int trackNumber)
    {
        return songList.findSong(trackNumber);
    }
    public Track findSong(String trackName)
    {
        return songList.findSong(trackName);
    }

    private static class songList
    {
        static private ArrayList<Track> tracks;
        public songList()
        {
            tracks = new ArrayList<>();
        }
        private static boolean addSong(Track track)
        {
            if (get(track.trackName) != -1)
            {
                return false;
            }
            tracks.add(track);
            return true;
        }
        private static Track findSong(String trackName)
        {
            if (get(trackName) != -1)
            {
                return tracks.get(get(trackName));
            }
            return null;
        }
        private static Track findSong(int trackNumber)
        {
            for (Track track : tracks)
            {
                if (track.trackNumber == trackNumber)
                {
                    return track;
                }
            }
            return null;
        }
        private static int get(String name)
        {
            for (int i = 0; i<tracks.size(); i++)
            {
                if (tracks.get(i).trackName.equalsIgnoreCase(name))
                {
                    return i;
                }
            }
            return -1;
        }
    }
    private class Track
    {
        private String trackName;
        private int trackNumber;

        public Track(String trackName, int trackNumber) {
            this.trackName = trackName;
            this.trackNumber = trackNumber;
        }

        public String getTrackName() {
            return trackName;
        }

        public int getTrackNumber() {
            return trackNumber;
        }
    }
}
