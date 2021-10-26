package com.spandigital.rickyconntournamentrankingsystemimplementation;

import com.spandigital.rickyconntournamentrankingsystem.Tournament;

public class TournamentRankingSystem
{
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            Tournament tournament = new Tournament(args[0]);
            tournament.printTeams();
        }
        else
        {
            System.out.println("Please enter the file path as the first argument");
        }
    }
}
