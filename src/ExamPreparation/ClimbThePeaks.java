package ExamPreparation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClimbThePeaks {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> portionsStack = new ArrayDeque<>();
            int[] foodSupplies = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < foodSupplies.length; i++) {
                portionsStack.push(foodSupplies[i]);
            }
            ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
            int[] stamina = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < stamina.length; i++) {
                staminaQueue.offer(stamina[i]);
            }
            boolean vihren = false;
            boolean kutelo = false;
            boolean banskiSuhodol = false;
            boolean polezhan = false;
            boolean kamenitza = false;
            boolean allClimbed = false;
            while (!portionsStack.isEmpty() && !staminaQueue.isEmpty()) {
                int sum = portionsStack.peek() + staminaQueue.peek();
                if (!vihren) {
                    if (sum >= 80) {
                        vihren = true;
                    }
                } else if (!kutelo) {
                    if (sum >= 90) {
                        kutelo = true;
                    }
                } else if (!banskiSuhodol) {
                    if (sum >= 100) {
                        banskiSuhodol = true;
                    }
                } else if (!polezhan) {
                    if (sum >= 60) {
                        polezhan = true;
                    }
                } else {
                    if (sum >= 70) {
                        kamenitza = true;
                    }
                }
                portionsStack.pop();
                staminaQueue.poll();
                if (vihren) {
                    if (kutelo) {
                        if (banskiSuhodol) {
                            if (polezhan) {
                                if (kamenitza) {
                                    allClimbed = true;
                                }
                            }
                        }
                    }
                }
                if (allClimbed) {
                    break;
                }
            }
            if (allClimbed) {
                System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
                System.out.println("Conquered peaks:");
                System.out.println("Vihren");
                System.out.println("Kutelo");
                System.out.println("Banski Suhodol");
                System.out.println("Polezhan");
                System.out.println("Kamenitza");
            } else {
                System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
                if (vihren) {
                    System.out.println("Conquered peaks:");
                    System.out.println("Vihren");
                    if (kutelo) {
                        System.out.println("Kutelo");
                    }
                    if (banskiSuhodol) {
                        System.out.println("Banski Suhodol");
                    }
                    if (polezhan) {
                        System.out.println("Polezhan");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
