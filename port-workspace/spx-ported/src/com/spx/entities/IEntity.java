package com.spx.entities;
    public interface IEntity
    {
        boolean contains(Point2 target);
        void Draw();
        void Update();
        void LoadContent();
        Point2 GetLocation();
        int GetEntityType();
        boolean IsActive();
        boolean IsBlocking();
        void SetInactive();
    }