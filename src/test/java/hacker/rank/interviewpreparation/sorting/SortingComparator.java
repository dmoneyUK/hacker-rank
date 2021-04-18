package hacker.rank.interviewpreparation.sorting;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Objects.requireNonNull;

public class SortingComparator {
    
    private Checker checker = new Checker();
    
    @Test
    public void testQuickSort() {
        
        Player[] players = {new Player("amy", 100), new Player("david", 100), new Player("heraldo", 50), new Player("aakansha", 75),
                            new Player("aleksa", 150)};
        
        quickSort(players, 0, players.length - 1);
        
        Arrays.stream(players).forEach(p -> System.out.println(p.name + " " + p.score));
    }
    
    private void quickSort(Player[] players, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = (right - left) / 2;
        
        int index = partition(players, left, right, pivot);
        quickSort(players, left, index - 1);
        quickSort(players, index, right);
    }
    
    private int partition(Player[] players, int left, int right, int pivot) {
        
        while (left < right) {
            
            while (checker.compare(players[left], players[pivot]) > 0) {
                left++;
            }
            
            while (checker.compare(players[right], players[pivot]) < 0) {
                right--;
            }
            
            Player temp = players[left];
            players[left] = players[right];
            players[right] = temp;
            
            left++;
            right--;
            
        }
        
        return left;
        
    }
    
    class Checker implements Comparator<Player> {
        
        @Override
        public int compare(Player a, Player b) {
            requireNonNull(a);
            requireNonNull(b);
            
            if (a.score > b.score) {
                return 1;
            } else if (a.score < b.score) {
                return -1;
            } else {
                
                int nameComparingResult = a.name.compareTo(b.name);
                if (nameComparingResult > 0) {
                    return -1;
                } else if (nameComparingResult < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
    
    public class Player {
        private String name;
        private int score;
        
        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int getScore() {
            return score;
        }
        
        public void setScore(int score) {
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            
            Player player = (Player) o;
            
            return new EqualsBuilder().append(score, player.score).append(name, player.name).isEquals();
        }
        
        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(name).append(score).toHashCode();
        }
        
        @Override
        public String toString() {
            return "Player{" + "name='" + name + '\'' + ", score=" + score + '}';
        }
    }
}
