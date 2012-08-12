package com.spx.entities;
import com.xna.wrapper.*;
    {
        private static List<IEntity> _contents = new ArrayList<IEntity>();
        private static HashMap<Point2,List<IEntity>> _gridContents = new HashMap<Point2, List<IEntity>>();

        public static IEntity addObject(IEntity Entity)
        {
            Entity.LoadContent();
            _contents.add(Entity);
            addToGrid(Entity);
            return Entity;
        }

        public static IEntity GetObject(int type)
        {
            if (_contents != null)
            {
            }
            return null;
        }

        private static List<IEntity> gopResults = new ArrayList<IEntity>();
        public static List<IEntity> GetEntities(int type,Point2 target)

            if (_contents != null)
            {
                goResults.clear();
                goResults.addAll(GetObjects(type));
                gopResults.clear();
                for (int ii = 0; ii < goResults.size(); ii++)
                {
                    if (goResults.get(ii).contains(target))
                    {
                        gopResults.add(goResults.get(ii));
                    }
                }
                return gopResults;
            }
            return null;
        }

        private static List<IEntity> goResults = new ArrayList<IEntity>();
        public static List<IEntity> GetObjects(int type)
        {
            goResults.clear();
            for (int ii = 0; ii < _contents.size(); ii++)
            {
                if (_contents.get(ii).GetEntityType() == type)
                {
                    goResults.add(_contents.get(ii));
                }
            }
            return goResults;
        }

        //CT Accessors
        public static IActor GetActor(int type)
        {
        }

        private static List<IActor> creatures = new ArrayList<IActor>();
        public static List<IActor> GetActors(int type)
        {
            creatures.clear();
            if (type != ActorType.NONPLAYER)
            {
                for (IEntity elem: _contents)
                {
                    if (elem.GetEntityType() == EntityType.ACTOR)
                    {
                        if (((IActor)elem).GetActorType() == type)
                        {
                            creatures.add(((IActor)elem));
                        }
                    }
                }
            }
            else
            {
                for(IEntity elem: _contents)
                {
                    if (elem.GetEntityType() == EntityType.ACTOR)
                    {
                        if (((IActor)elem).GetActorType() != ActorType.PLAYER)
                        {
                            creatures.add(((IActor)elem));
                        }
                    }
                }
            }
            return creatures;
        }

        private static IActor _nextResult;
        public static List<IActor> GetActorsAt(Point2 target,int actorType)
        {
            creatures.clear();
            for(IEntity elem: _gridContents.get(target))
            {
                if (elem.GetEntityType() == EntityType.ACTOR)
                {
                    _nextResult = (IActor)elem;
                    if (actorType == -1 
                        || _nextResult.GetActorType() == actorType
                        || (actorType == ActorType.NONPLAYER && _nextResult.GetActorType() != ActorType.PLAYER))
                    {
                        creatures.add(_nextResult);
                    }
                }
            }
            return creatures;
        }

        private static List<IActor> creatures2 = new ArrayList<IActor>();
        public static List<IActor> GetActorsSurrounding(Point2 target,int distance)

            creatures2.clear();
            for (int ii = -distance; ii < distance+1; ii++)
            {
                for (int jj = -distance; jj < distance+1; jj++)
                {
                    if (ii != 0 || jj != 0)
                    {
                        for (IActor creature : GetActorsAt(target.Add(new Point2(ii, jj)),-1))
                        {
                            creatures2.add(creature);
                        }
                    }
                }
            }
            return creatures2;
        }

        public static boolean IsLocationBlocked(Point2 location)
        {
            for(IEntity elem : _gridContents.get(location))
            {
                if(elem.IsBlocking())
                {
                    return true;
                }
            }
            return false;
        }
        public static List<IEntity> GetObjectsToCache()
        {
            return gotcResults;
        }

        public static IActor GetNearestPlayer(IEntity target)
        }

        public static IActor GetNearestPlayer(IActor target)

            return (IActor)GetNearestPlayer((IEntity)target);
        }

        public static void addObjects(List<IEntity> cache)
        {
            _contents.addAll(cache);
        }

        public static boolean AnyContains(Point2 target, int type)
        }

        public static void RemoveObject(IEntity target)
            _contents.remove(target);
        }

        public static void Clear()
        {
            _contents = new ArrayList<IEntity>();
            _gridContents = new HashMap<Point2, List<IEntity>>();
        }

        public static void Reset()
        {
            _contents = new ArrayList<IEntity>();
            _gridContents = new HashMap<Point2, List<IEntity>>();
            creatures.clear();
            LoadContent();
        }

        public static void Update()
        {   
            for (int ii = 0; ii < _contents.size(); ii++)
            {
                if(ii>=_contents.size())
                {
                    return;
                }
                if (!_contents.get(ii).IsActive())
                {
                    _gridContents.get(_contents.get(ii).GetLocation()).remove(_contents.get(ii));
                    _contents.remove(_contents.get(ii));
                    ii--;
                    continue;
                }                
                _contents.get(ii).Update();
            }
        }

        public static void Draw()
        {
            if (XnaManager.Renderer != null)
            {
                for (IEntity component : _contents)
                {
                    component.Draw();
                }
            }
        }

        public static void LoadContent()
        {
            if (XnaManager.Renderer != null)
            {
                for (IEntity component : _contents)
                {
                    component.LoadContent();
                }
            }
        }

        private static void addToGrid(IEntity entity)
        {
            if (!_gridContents.containsKey(entity.GetLocation()))
            {
                _gridContents.put(entity.GetLocation(), new ArrayList<IEntity>());
            }            
            _gridContents.get(entity.GetLocation()).add(entity);
        }

        public static void UpdateGridLocation(IEntity Entity, Point2 oldLocation)
        {
            if(_gridContents!=null && oldLocation !=null)
            {
                _gridContents.get(oldLocation).remove(Entity);
                addToGrid(Entity);
            }
        }

        private static List<IActor> _players = new ArrayList<IActor>();
        public static List<IActor> GetPlayers()
        {
            _players.clear();
            for (IEntity tile : _contents)
            {
                if (tile.GetEntityType() == EntityType.ACTOR && ((IActor)tile).GetActorType() == ActorType.PLAYER)
                {
                    _players.add((IActor)tile);
                }
            }
            return _players;
        }

        //Returns a space that has no creatures on it
        private static List<Point2> emptyLocations;
        public static Point2 GetEmptyLocation()
        {
           return emptyLocations.get(RNG.Next(0, emptyLocations.size()));
        }

        public static List<IEntity> GetEntitiesToCache()
        {
            return results;
        }
        public static IActor GetTouchingCreature(IEntity entity)
        {
        }
    }