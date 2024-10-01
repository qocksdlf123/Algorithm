import java.util.*;

class Solution {
    static int pairCount, n, cardValue;
    static boolean stop;
    static Iterator<Integer> iterator;

    public int solution(int coin, int[] cards) {
        n = cards.length;
        int answer = 1;
        Set<Integer> currentSet = new HashSet<>(), nonCurrentSet = new HashSet<>(), toRemoveSet = new HashSet<>();

        for (int i = 0; i < n / 3; i++) currentSet.add(cards[i]);

        iterator = currentSet.iterator();
        while (iterator.hasNext()) {
            cardValue = iterator.next();
            if (currentSet.contains(n + 1 - cardValue)) {
                toRemoveSet.add(cardValue);
                toRemoveSet.add(n + 1 - cardValue);
                pairCount++;
            }
        }
        pairCount /= 2;
        currentSet.removeAll(toRemoveSet);
        toRemoveSet.clear();

        int i = n / 3;
        while (true) {
            if (i >= n || stop) break;
            nonCurrentSet.add(cards[i]);
            nonCurrentSet.add(cards[i + 1]);

            if (removePairsWithCoins(currentSet, nonCurrentSet, cards[i], coin)) coin--;
            if (removePairsWithCoins(currentSet, nonCurrentSet, cards[i + 1], coin)) coin--;

            if (pairCount > 0) {
                pairCount--;
                answer++;
                i += 2;
                continue;
            }

            stop = true;
            iterator = nonCurrentSet.iterator();
            while (iterator.hasNext()) {
                cardValue = iterator.next();
                if (coin >= 2 && nonCurrentSet.contains(n + 1 - cardValue)) {
                    toRemoveSet.add(cardValue);
                    toRemoveSet.add(n + 1 - cardValue);
                    stop = false;
                    answer++;
                    coin -= 2;
                    i += 2;
                    break;
                }
            }
            nonCurrentSet.removeAll(toRemoveSet);
        }
        return answer;
    }

    private boolean removePairsWithCoins(Set<Integer> currentSet, Set<Integer> nonCurrentSet, int card, int coin) {
        if (currentSet.contains(n - card + 1) && coin > 0) {
            currentSet.remove(n - card + 1);
            nonCurrentSet.remove(card);
            pairCount++;
            return true;
        }
        return false;
    }
}