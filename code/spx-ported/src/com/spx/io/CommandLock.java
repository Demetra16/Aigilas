package com.spx.io;

public class CommandLock
{
    public CommandLock(int command, int playerIndex)
    {
        Command = command;
        PlayerIndex = playerIndex;
    }
    public int Command;
    public int PlayerIndex ;
}