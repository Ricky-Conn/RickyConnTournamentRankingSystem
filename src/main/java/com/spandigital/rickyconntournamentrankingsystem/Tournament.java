package com.spandigital.rickyconntournamentrankingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Tournament
{
    private ArrayList<String> matches = new ArrayList<>();
    private HashMap<String, Integer> teams = new HashMap<>();

    public Tournament(String filename)
    {
        readMatches(filename);
        processMatches();
    }
    
    private void processMatches()
    {
        try
        {
            for(String match : matches)
            {
                String[] scores = match.split(", ");

                if (scores.length == 2)
                {
                    judgeMatch(getTeamName(scores[0]),getTeamScore(scores[0]),getTeamName(scores[1]),getTeamScore(scores[1]));
                }
                else
                {
                    throw new Exception("Invalid input: match results should be seperated by a comma.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void judgeMatch(String teamOneName, int teamOneScore, String teamTwoName, int teamTwoScore)
    {
            if (teamOneScore > teamTwoScore)
            {
                addToPoints(teamOneName, 3);
                addToPoints(teamTwoName, 0);
            }
            else if (teamOneScore < teamTwoScore)
            {
                addToPoints(teamOneName, 0);
                addToPoints(teamTwoName, 3);
            }
            else
            {
                addToPoints(teamOneName, 1);
                addToPoints(teamTwoName, 1);
            }
    }

    private String getTeamName(String teamResult) throws Exception
    {
        String teamName = teamResult.substring(0, teamResult.lastIndexOf(" "));
        if(teamName.length() == 0)
        {
            throw new Exception("Invalid input: team's name must have at least one character.");
        }
        return teamName;
    }

    private int getTeamScore(String teamResult) throws Exception
    {
        try
        {
            return Integer.parseInt(teamResult.substring(teamResult.lastIndexOf(" ") + 1));
        }
        catch (Exception e)
        {
            throw new Exception("Invalid input: team's score cannot contain a non-numeric character.");
        }
    }

    //Adds points to team. If the team doesn't exist in teams HashMap then it is added to the Map.
    private void addToPoints(String teamName, int points)
    {
        if (teams.get(teamName) == null)
        {
            teams.put(teamName, points);
        }
        else
        {
            teams.put(teamName, teams.get(teamName) + points);
        }
    }

    private void readMatches(String filename)
    {
        try
        {
            String fullFilePath = System.getProperty("user.dir") + File.separator + filename;
            BufferedReader reader = new BufferedReader(new FileReader(fullFilePath));
            String match = reader.readLine();

            while (match != null)
            {
                matches.add(match);
                match = reader.readLine();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex);
        }
    }

    public void printTeams()
    {
        List<Entry<String, Integer>> teamsList = new LinkedList<Entry<String, Integer>>(teams.entrySet());

        Collections.sort(teamsList, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (o1.getValue() > o2.getValue())
                {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue())
                {
                    return 1;
                }
                else
                {
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                }
            }
        });

        for (int i = 1; i <= teamsList.size(); i++)
        {
            Entry<String, Integer> team = teamsList.get(i - 1);
            System.out.println(i + ". " + team.getKey() + ", " + team.getValue() + " pts");
        }
    }
    
    /*------------------------------------------------------------------------*/
    /*                    Getters and setters                                 */
    /*------------------------------------------------------------------------*/
    
    public ArrayList<String> getMatches()
    {
        return matches;
    }

    public void setMatches(ArrayList<String> matches)
    {
        this.matches = matches;
    }

    public HashMap<String, Integer> getTeams()
    {
        return teams;
    }

    public void setTeams(HashMap<String, Integer> teams)
    {
        this.teams = teams;
    }
}
