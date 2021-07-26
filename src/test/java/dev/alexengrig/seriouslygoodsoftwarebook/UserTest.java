package dev.alexengrig.seriouslygoodsoftwarebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testFriendship() {
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");
        User user4 = new User("User 4");
        User user5 = new User("User 5");

        user1.befriend(user2);
        user2.befriend(user3);
        user3.befriend(user4);
        user4.befriend(user1);

        // Direct

        assertTrue(user1.isDirectFriendOf(user2));
        assertFalse(user1.isDirectFriendOf(user3));
        assertTrue(user1.isDirectFriendOf(user4));
        assertFalse(user1.isDirectFriendOf(user5));

        assertTrue(user2.isDirectFriendOf(user1));
        assertTrue(user2.isDirectFriendOf(user3));
        assertFalse(user2.isDirectFriendOf(user4));
        assertFalse(user2.isDirectFriendOf(user5));

        assertFalse(user3.isDirectFriendOf(user1));
        assertTrue(user3.isDirectFriendOf(user2));
        assertTrue(user3.isDirectFriendOf(user4));
        assertFalse(user3.isDirectFriendOf(user5));

        assertTrue(user4.isDirectFriendOf(user1));
        assertFalse(user4.isDirectFriendOf(user2));
        assertTrue(user4.isDirectFriendOf(user3));
        assertFalse(user4.isDirectFriendOf(user5));

        assertFalse(user5.isDirectFriendOf(user1));
        assertFalse(user5.isDirectFriendOf(user2));
        assertFalse(user5.isDirectFriendOf(user3));
        assertFalse(user5.isDirectFriendOf(user4));

        // Indirect

        assertFalse(user1.isIndirectFriendOf(user2));
        assertTrue(user1.isIndirectFriendOf(user3));
        assertFalse(user1.isIndirectFriendOf(user4));
        assertFalse(user1.isIndirectFriendOf(user5));

        assertFalse(user2.isIndirectFriendOf(user1));
        assertFalse(user2.isIndirectFriendOf(user3));
        assertTrue(user2.isIndirectFriendOf(user4));
        assertFalse(user2.isIndirectFriendOf(user5));

        assertTrue(user3.isIndirectFriendOf(user1));
        assertFalse(user3.isIndirectFriendOf(user2));
        assertFalse(user3.isIndirectFriendOf(user4));
        assertFalse(user3.isIndirectFriendOf(user5));

        assertFalse(user4.isIndirectFriendOf(user1));
        assertTrue(user4.isIndirectFriendOf(user2));
        assertFalse(user4.isIndirectFriendOf(user3));
        assertFalse(user4.isIndirectFriendOf(user5));

        assertFalse(user5.isIndirectFriendOf(user1));
        assertFalse(user5.isIndirectFriendOf(user2));
        assertFalse(user5.isIndirectFriendOf(user3));
        assertFalse(user5.isIndirectFriendOf(user4));
    }
}