﻿using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Input;
using OGUR.Util;

namespace OGUR.Management
{
    public class Commands
    {
        public const int MoveUp = 0;
        public const int MoveDown = 1;
        public const int MoveLeft = 2;
        public const int MoveRight = 3;
        public const int Confirm = 4;
        public const int Inventory = 5;
        public const int Skill = 6;
        public const int CycleLeft = 7;
        public const int CycleRight = 8;
        public const int Cancel = 9;
        public const int Start = 10;
        public const int Back = 11;
    }
    public class Contexts
    {
        public const int All = 0;
        public const int Nonfree = 1;
        public const int Free = 2;
        public const int Inventory = 3;
    }
    public class InputManager
    {
        

        private static readonly Dictionary<int, int> m_contexts = new Dictionary<int, int>()
                                                                  {
                                                                      {0, Contexts.Free},
                                                                      {1, Contexts.Free},
                                                                      {2, Contexts.Free},
                                                                      {3, Contexts.Free}

                                                                  };
        private static readonly List<CommandLock> s_locks = new List<CommandLock>(); 

        private static readonly Dictionary<int,int> s_lockOnPress = new Dictionary<int,int>()
                                                          {
                                                              {Commands.Confirm,Contexts.All},
                                                              {Commands.Inventory,Contexts.All},
                                                              {Commands.Cancel,Contexts.All},
                                                              {Commands.Start,Contexts.All},
                                                              {Commands.Back,Contexts.All},
                                                              {Commands.MoveRight,Contexts.Nonfree},
                                                              {Commands.MoveLeft,Contexts.Nonfree},
                                                              {Commands.MoveUp,Contexts.Nonfree},
                                                              {Commands.MoveDown,Contexts.Nonfree},
                                                              {Commands.CycleLeft,Contexts.All},
                                                              {Commands.CycleRight,Contexts.All},
                                                              {Commands.Skill,Contexts.All}
                                                          }; 

        private static readonly Dictionary<int, Keys> m_keyboardMapping = new Dictionary<int, Keys>()
                                                                                   {
                                                                                       {Commands.MoveUp, Keys.Up},
                                                                                       {Commands.MoveDown, Keys.Down},
                                                                                       {Commands.MoveRight, Keys.Right},
                                                                                       {Commands.MoveLeft, Keys.Left},
                                                                                       {Commands.Inventory,Keys.E},
                                                                                       {Commands.Confirm, Keys.Space},
                                                                                       {Commands.Cancel,Keys.R},
                                                                                       {Commands.Start,Keys.Enter},
                                                                                       {Commands.Back,Keys.Back},
                                                                                       {Commands.CycleLeft,Keys.A},
                                                                                       {Commands.CycleRight,Keys.D},
                                                                                       {Commands.Skill,Keys.S}
                                                                                   };

        private static readonly Dictionary<int, Buttons> m_gamePadMapping = new Dictionary<int, Buttons>()
                                                                                     {
                                                                                         {Commands.MoveUp,Buttons.LeftThumbstickUp},
                                                                                         {Commands.MoveDown,Buttons.LeftThumbstickDown},
                                                                                         {Commands.MoveRight,Buttons.LeftThumbstickRight},
                                                                                         {Commands.MoveLeft,Buttons.LeftThumbstickLeft},
                                                                                         {Commands.Confirm,Buttons.A},
                                                                                         {Commands.Inventory,Buttons.Y},
                                                                                         {Commands.Cancel,Buttons.X},
                                                                                         {Commands.Start,Buttons.Start},
                                                                                         {Commands.Back,Buttons.Back},
                                                                                         {Commands.CycleLeft,Buttons.LeftShoulder},
                                                                                         {Commands.CycleRight,Buttons.RightShoulder},
                                                                                         {Commands.Skill,Buttons.RightTrigger}
                                                                                     };

        private static readonly List<PlayerIndex> m_playerIndex = new List<PlayerIndex>()
                                                                      {
                                                                          PlayerIndex.One,
                                                                          PlayerIndex.Two,
                                                                          PlayerIndex.Three,
                                                                          PlayerIndex.Four
                                                                      };
        private static readonly Dictionary<int, bool> s_inputs = new Dictionary<int, bool>();
        private static bool s_isInputActive = false;
        private static bool s_isDown = false;

        private static bool IsDown(int command, int playerIndex)
        {
            if (!s_inputs.ContainsKey(playerIndex))
            {
                s_inputs.Add(playerIndex, GamePad.GetState(m_playerIndex[playerIndex]).IsConnected);
            }
            else
            {
                if (s_inputs[playerIndex])
                {
                    s_isDown = GamePad.GetState(m_playerIndex[playerIndex]).IsButtonDown(m_gamePadMapping[command]);
                }
                else
                {
                    s_isDown = Keyboard.GetState().IsKeyDown(m_keyboardMapping[command]);
                }
            }
            return s_isDown;
        }

        public static bool IsPressed(int command, int playerIndex,bool failIfLocked=true)
        {
            
            s_isInputActive = IsDown(command,playerIndex);
            
            if (!s_isInputActive)
            {
                if (ShouldLock(command,playerIndex))
                {
                    Unlock(command, playerIndex);
                }
            }

            if (IsLocked(command, playerIndex) && failIfLocked)
            {
                return false;
            }

            if (s_isInputActive)
            {
                if(ShouldLock(command,playerIndex))
                {
                    Lock(command,playerIndex);
                }
            }

            return s_isInputActive;
        }

        private static bool ShouldLock(int command,int playerIndex)
        {
            foreach(var key in s_lockOnPress.Keys)
            {
                if (key == command)
                {
                    if (s_lockOnPress[key] == m_contexts[playerIndex] ||
                        (s_lockOnPress[key] == Contexts.Nonfree && m_contexts[playerIndex] != Contexts.Free) ||
                        s_lockOnPress[key] == Contexts.All)
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public static void SetContext(int context,int playerIndex)
        {
            m_contexts[playerIndex] = context;
        }
        public static bool IsContext(int context,int playerIndex)
        {
            return m_contexts[playerIndex] == context;
        }
        public static bool IsLocked(int command,int playerIndex)
        {
            foreach (var pair in s_locks)
            {
                if (pair.Command == command && pair.PlayerIndex == playerIndex)
                {
                    return true;
                }
            }
            return false;
        }
        public static void Lock(int command,int playerIndex)
        {
            s_locks.Add(new CommandLock(command,playerIndex));
        }
        public static void Unlock(int command, int playerIndex)
        {
            for(int ii = 0;ii<s_locks.Count();ii++)
            {
                if(s_locks[ii].Command==command && s_locks[ii].PlayerIndex==playerIndex)
                {
                    s_locks.Remove(s_locks[ii]);
                    ii--;
                }
            }
        }

        public static void Update()
        {
            for(int ii = 0;ii<s_locks.Count();ii++)
            {
                if (!IsDown(s_locks[ii].Command, s_locks[ii].PlayerIndex))
                {
                    s_locks.Remove(s_locks[ii]);
                    ii--;
                }
            }
        }
    }

    public class CommandLock
    {
        public CommandLock(int command, int playerIndex)
        {
            Command = command;
            PlayerIndex = playerIndex;
        }
        public int Command;
        public int PlayerIndex{ get; set; }
    }
}