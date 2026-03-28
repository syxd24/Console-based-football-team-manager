package org.example;

/**
 * Functional interface for filtering players based on a custom condition.
 *
 * Using our own interface (rather than {@link java.util.function.Predicate})
 * keeps the domain language clean and self-documenting.
 *
 * Example usage:
 *   PlayerFilter youngPlayers = player -> player.getAge() < 22;
 */

@FunctionalInterface
public interface PlayerFilter {
    boolean test(Player player);
}