package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service layer for managing a team's squad.
 *
 * Provides player lookup, filtering, salary calculations,
 * and squad analytics using the Java Streams API.
 *
 * All query methods return new collections — the internal squad list
 * is never exposed directly to callers.
 */

public class TeamService {

    // The squad roster — populated via addPlayer()
    private final List<Player> players = new ArrayList<>();

    // -------------------------------------------------------------------------
    // Squad Management
    // -------------------------------------------------------------------------

    /**
     * Adds a player to the squad.
     * Tip: Add validation here later (e.g. duplicate jersey numbers).
     */

    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Prints every player to stdout — handy for quick debugging.
     */

    public void showAllPlayers() {
        players.forEach(System.out::println);
    }

    // -------------------------------------------------------------------------
    // Filtering
    // -------------------------------------------------------------------------

    /**
     * Returns players matching an arbitrary filter condition.
     *
     * This is the most flexible method in the service — any lambda works:
     *   service.filteredPlayers(p -> p.getAge() < 25 && p.getSalary() > 20000)
     */

    public List<Player> filteredPlayers(PlayerFilter filter) {
        return players.stream()
                .filter(filter::test)
                .collect(Collectors.toList());
    }

    /**
     * Returns all players playing in a given position (case-sensitive).
     * E.g. "Striker", "Defender", "Winger"
     */

    public List<Player> getPlayersByPosition(String position) {
        return players.stream()
                .filter(player -> player.getPosition().equals(position))
                .collect(Collectors.toList());
    }

    /**
     * Returns players strictly older than the given age.
     * Useful for analysing squad age profile.
     */

    public List<Player> getPlayersAboveAge(int age) {
        return players.stream()
                .filter(player -> player.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Returns players earning more than the given salary threshold.
     * Useful for budget reviews.
     */
    public List<Player> getPlayersAboveSalary(double salary) {
        return players.stream()
                .filter(player -> player.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------
    // Lookup
    // -------------------------------------------------------------------------

    /**
     * Finds a player by their unique ID.
     * Returns Optional.empty() if no match — avoids null-pointer surprises.
     */

    public Optional<Player> findPlayerById(int id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }

    /**
     * Finds a player by jersey number.
     * In a valid squad each jersey is unique, so findFirst() is safe here.
     */

    public Optional<Player> findPlayerByJerseyNumber(int jerseyNumber) {
        return players.stream()
                .filter(player -> player.getJerseyNumber() == jerseyNumber)
                .findFirst();
    }

    // -------------------------------------------------------------------------
    // Analytics
    // -------------------------------------------------------------------------

    /**
     * Calculates the total wage bill for the whole squad.
     * Uses reduce() to accumulate salaries from a clean 0.0 base.
     */

    public double calculateTotalSalary() {
        return players.stream()
                .mapToDouble(Player::getSalary)  // mapToDouble is cleaner than map + reduce for primitives
                .sum();
    }

    /**
     * Returns all player names in UPPER CASE.
     * Could be used for display in match programmes, scorecards, etc.
     */
    public List<String> getPlayerNamesUpperCase() {
        return players.stream()
                .map(Player::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Returns the distinct positions present in the squad.
     * Useful for a quick overview of squad shape / formation options.
     */
    public List<String> getUniquePositions() {
        return players.stream()
                .map(Player::getPosition)
                .distinct()
                .collect(Collectors.toList());
    }
}