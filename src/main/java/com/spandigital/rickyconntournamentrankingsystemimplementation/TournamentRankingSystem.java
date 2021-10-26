package com.spandigital.rickyconntournamentrankingsystemimplementation;

import com.spandigital.rickyconntournamentrankingsystem.Tournament;

public class TournamentRankingSystem
{
    public static void main(String []args)
    {
        Tournament tournament = new Tournament();
        
        if(args.length > 0)
        {
            tournament.readMatches(args[0]);
        }else
        {
            System.out.println("Please enter the file path as the first argument");
        }
    }
}
