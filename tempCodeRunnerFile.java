class Brain {
    private String lastMove;

    public Brain() {
        lastMove = ""; // Initialize lastMove
    }

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        // Prioritize unexplored directions
        if (!lastMove.equals("south") && north) {
            lastMove = "north";
            return "north";
        }
        if (!lastMove.equals("north") && south) {
            lastMove = "south";
            return "south";
        }
        if (!lastMove.equals("west") && east) {
            lastMove = "east";
            return "east";
        }
        if (!lastMove.equals("east") && west) {
            lastMove = "west";
            return "west";
        }

        // If all directions are explored, choose a random direction
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0:
                lastMove = "north";
                return "north";
            case 1:
                lastMove = "south";
                return "south";
            case 2:
                lastMove = "east";
                return "east";
            default:
                lastMove = "west";
                return "west";
        }
    }
}
