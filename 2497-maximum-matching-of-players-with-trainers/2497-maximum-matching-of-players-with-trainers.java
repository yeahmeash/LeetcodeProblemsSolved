class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort the players array in ascending order
        Arrays.sort(players);
        // Sort the trainers array in ascending order
        Arrays.sort(trainers);

        // Initialize the count of matches to 0
        int matches = 0;
        // Initialize the index for trainers to 0
        int trainerIndex = 0;

        // Iterate over each player
        for (int player : players) {
            // Increment the trainerIndex until we find a trainer that can match the player
            while (trainerIndex < trainers.length && trainers[trainerIndex] < player) {
                trainerIndex++;
            }
            // If there is a trainer that can match the player, increment the match count
            if (trainerIndex < trainers.length) {
                matches++; // A match is found
                trainerIndex++; // Move to the next trainer.
            }
        }
        // Return the total count of matches
        return matches;
    }
}
