package com.spandigital.rickyconntournamentrankingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Tournament
{
    private HashMap<String, Integer> teams = new HashMap<>();

    public Tournament()
    {
    }

    public String judgeMatch(String match)
    {
        String[] scores = match.split(",");

        if (scores.length == 2)
        {
            String teamOneName = getTeamName(scores[0]);
            int teamOneScore = getTeamScore(scores[0]);

            String teamTwoName = getTeamName(scores[1]);
            int teamTwoScore = getTeamScore(scores[1]);

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

            return "success";
        }
        else
        {
            return "invalid";
        }
    }

    public String getTeamName(String teamResult)
    {
        return teamResult.substring(0, teamResult.lastIndexOf(" "));
    }

    public int getTeamScore(String teamResult)
    {
        return Integer.parseInt(teamResult.substring(teamResult.lastIndexOf(" ") + 1));
    }

    //Adds points to team. If the team doesn't exist in teams then adds the team.
    public void addToPoints(String teamName, int points)
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

    public void readMatches(String filename)
    {
        try
        {
            String fullFilePath = System.getProperty("user.dir") + File.separator + filename;
            BufferedReader reader = new BufferedReader(new FileReader(fullFilePath));
            String match = reader.readLine();

            while (match != null)
            {
                judgeMatch(match);
                match = reader.readLine();
            }

            printTeams();
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
}
