package com.t01g02.project.controller;

import com.t01g02.project.model.*;

import java.util.ArrayList;
import java.util.List;

import static com.t01g02.project.model.CharacterModel.friends;
import static com.t01g02.project.model.CharacterModel.hellokitty;

public class FriendsController {
    private static CityModel cityModel;
    private List<KittyObserver> observers = new ArrayList<KittyObserver>();

    public FriendsController(CityModel cityModel) {
        FriendsController.cityModel = cityModel;
    }

    private static boolean isWithinZone(Position position, Zone zone) {
        int tileX = position.getX();
        int tileY = position.getY();

        int zoneStartX = zone.getStartposition().getX();
        int zoneEndX = zone.getEndposition().getX()-20;
        int zoneStartY = zone.getStartposition().getY();
        int zoneEndY = zone.getEndposition().getY()+25;

        return tileX >= zoneStartX && tileX <= zoneEndX &&
                tileY >= zoneStartY && tileY <= zoneEndY;
    }

    public void checkPickup() {
        Position kittyPosition = CharacterModel.getHellokitty().getPosition();

        List<Zone> zones = cityModel.getZones();
        Zone zoneToRemove = null;

        for (Zone zone : zones) {
            if (zone.getType() == Tile.Type.PICKUP && isWithinZone(kittyPosition, zone)) {
                CharacterModel friend = zone.getAssociatedFriend();
                if (friend != null && !friend.isFollowing() && !hellokitty.isBeingFollowed()){
                    friend.setFollowing(true);
                    hellokitty.setBeingFollowed(true);
                    notifyPickedUp();

                    zoneToRemove = zone;
                }
            }
        }
        if (zoneToRemove != null) {
            zones.remove(zoneToRemove);
        }
    }

    public void checkDropoff() {

        for (Zone zone : cityModel.getZones()) {
            for (CharacterModel friend : friends){
                if (friend.isFollowing()) {
                    if (zone.getType() == Tile.Type.DROPOFF && isWithinZone(friend.getPosition(), zone)) {
                        friend.setFollowing(false);
                        hellokitty.setBeingFollowed(false);
                        notifyDroppedOff();

                    }
                }
            }
        }
    }
    public static void moveFollowingCharacters() {
        for (int i = 0; i < friends.size(); i++) {
            CharacterModel friend = friends.get(i);
            if (friend.isFollowing()) {
                follow(i);
            }
        }

    }

    public static void follow(int friendId) {
        Position kittyPos = hellokitty.getPosition();
        Position friendPos = friends.get(friendId).getPosition();
        CharacterModel friend = friends.get(friendId);
        List<Position> kittyPositionHistory = hellokitty.getKittyLastPositions();

        if (isWithinZone(kittyPos, cityModel.getZones().get(friendId))){
            return;
        }

        if (!kittyPositionHistory.isEmpty()) {
            Position kittyLastPosition = kittyPositionHistory.get(0);
            Position friendcurrentPos = friend.getPosition();
            friend.setPosition(kittyLastPosition);
            /*if (friendcurrentPos.getX() < kittyLastPosition.getX()) {
                friend.setPosition(new Position(friendcurrentPos.getX() + 1, friendcurrentPos.getY()));
            }
            if (friendcurrentPos.getX() > kittyLastPosition.getX()) {
                friend.setPosition(new Position(friendcurrentPos.getX() - 1, friendcurrentPos.getY()));
            }*/

            if (friendcurrentPos.getY() < kittyLastPosition.getY()) {
                friend.setPosition(new Position(friendcurrentPos.getX(), friendcurrentPos.getY() + 2));
            }
            /*if (friendcurrentPos.getY() > kittyLastPosition.getY()) {
                friend.setPosition(new Position(friendcurrentPos.getX(), friendcurrentPos.getY() - 1)); // Move up

            }*/

        }

    }



    public void addObserver(KittyObserver observer) {
        observers.add(observer);
    }
    public void notifyPickedUp() {
        for (KittyObserver observer : observers) {
            observer.friendPickedUp();
        }
    }

    public void notifyDroppedOff() {
        for (KittyObserver observer : observers) {
            observer.friendDroppedOff();
        }
    }

}
