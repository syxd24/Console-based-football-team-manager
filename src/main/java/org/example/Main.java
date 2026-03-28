package org.example;

/**
 * Entry point — demonstrates TeamService functionality.
 *
 * In a real app this would be wired up through a framework (Spring Boot, etc.)
 * or driven by a CLI/REST layer. For now it acts as a quick smoke-test.
 */
public class Main {

    public static void main(String[] args) {

        TeamService service = new TeamService();

        // --- Populate the squad ---
        service.addPlayer(new Player(1, "Ronaldo",  40, "Striker",  30000.00, 7));
        service.addPlayer(new Player(2, "Messi",    40, "Striker",  30000.00, 10));
        service.addPlayer(new Player(3, "Neymar",   39, "Winger",   25000.00, 11));
        service.addPlayer(new Player(4, "Ramos",    38, "Defender", 20000.00, 25));
        service.addPlayer(new Player(5, "Benzema",  34, "Striker",  20000.00, 9));
        service.addPlayer(new Player(6, "Pepe",     42, "Defender", 15000.00, 60));
        service.addPlayer(new Player(7, "Yamal",    18, "Winger",   25000.00, 12));

        // --- Demo: show all players ---
        System.out.println("=== Full Squad ===");
        service.showAllPlayers();

        // --- Demo: filter young players (under 22) ---
        System.out.println("\n=== Young Players (under 22) ===");
        service.filteredPlayers(p -> p.getAge() < 22)
                .forEach(System.out::println);

        // --- Demo: all strikers ---
        System.out.println("\n=== Strikers ===");
        service.getPlayersByPosition("Striker")
                .forEach(System.out::println);

        // --- Demo: players older than 38 ---
        System.out.println("\n=== Players above age 38 ===");
        service.getPlayersAboveAge(38)
                .forEach(System.out::println);

        // --- Demo: unique positions in squad ---
        System.out.println("\n=== Unique Positions ===");
        System.out.println(service.getUniquePositions());

        // --- Demo: total wage bill ---
        System.out.printf("%n=== Total Squad Salary: %.2f ===%n", service.calculateTotalSalary());

        // --- Demo: safe lookup with Optional ---
        System.out.println("\n=== Find player by jersey #10 ===");
        service.findPlayerByJerseyNumber(10)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No player found with that jersey number.")
                );
    }
}