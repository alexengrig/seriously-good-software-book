package dev.alexengrig.seriouslygoodsoftwarebook;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class User {
    private final String name;
    private final Set<User> friends = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public void befriend(User other) {
        friends.add(other);
        other.friends.add(this);
    }

    public boolean isDirectFriendOf(User other) {
        return friends.contains(other);
    }

    public boolean isIndirectFriendOf(User other) {
        if (isDirectFriendOf(other)) {
            return false;
        }
        Set<User> visited = new HashSet<>();
        Queue<User> queue = new ArrayDeque<>(friends);
        User friend;
        while ((friend = queue.poll()) != null) {
            if (visited.contains(friend)) {
                continue;
            } else if (friend.friends.contains(other)) {
                return true;
            }
            visited.add(friend);
            queue.addAll(friend.friends);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
