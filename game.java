import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class game {
    static int     UNIT_WAIT_TIME_MS = 250;
    static Scanner SCANNER           = new Scanner(System.in);
    public static void main(String[] args) {
        setWaitTime();
        printAndWait("Hi, welcome to 4 corners.", 4);
        printAndWait("Pick one corner out of four options.", 6);
        printAndWait("The goal of the game is to avoid getting your corner picked.", 8);
        printAndWait("If your corner is picked, you lose. Good Luck.", 6);
        int choice2 = getInputInt("Do you want to play? Yes(1) or No(2)");
        if (choice2 == 1) {
            int choice3 = getInputInt("How many players(excluding 'it') do you want in the game? Enter between 1 to 499.");
            if (choice3 <= 1) {
                choice3 = 1;
            }
            if (choice3 >= 499) {
                choice3 = 499;
            }
            int roundsorlast = getInputInt("Do you want to play with rounds(1) or do you want to play until you lose or you're the last player standing(2)?");
            if (roundsorlast == 1) {
                int choice4 = getInputInt("Great! Now, do you want to be a player(1) or be 'it'(2)?");
                int rounds = getInputInt("How many rounds do you want? Enter between 1-75.");
                if (rounds <= 1) {
                    rounds = 1;
                }
                if (rounds >= 75) {
                    rounds = 75;
                }
                int x = 0;
                if (choice4 <= 1) {
                    choice3++;
                    printAndWait("You are now a player.", 3);
                    while (rounds > x) {
                        printAndWait("There are currently " +choice3+ " players (excluding 'it' and including you) in the game.", 9);
                        int options = choice3;
                        int choice5 = getInputInt("What corner do you pick? Corner 1(1), Corner 2(2), Corner 3(3), or Corner 4(4)");
                        int itsNumber = (int) ((Math.random() * 4) + 1);
                        for (int i = 1; i < options; i++) {
                            int player = (int) ((Math.random() * 4) + 1);
                            if (player == itsNumber) {
                                choice3--;
                            }
                        }
                        printAndWait("Choosing...", 16);
                        print("'It' chose " + itsNumber);
                        x++;
                        if (choice5 != itsNumber && choice5 <= 4 && choice5 >= 1) {
                            printAndWait("Good job! You passed this round.", 6);
                            if (rounds == x) {
                                print("You win! "+choice3+" player(s) won in total.");
                            }
                        } else {
                            choice3--;
                            printAndWait("Remaining players left: "+choice3, 4);
                            print("Good try.");
                            int spectate = getInputInt("Do you want to spectate? Yes(1), No(2).");
                            if (spectate == 2) {
                                print("Goodbye.");
                                x+=1000;
                                break;
                            } else {
                                if (rounds == x) {
                                    print(choice3 + " players won.");
                                }
                                while (rounds > x) {
                                    options = choice3;
                                    int itsNumber2 = (int) ((Math.random() * 4) + 1);
                                    printAndWait("There are currently " +choice3+ " players (excluding 'it') in the game.", 4);
                                    printAndWait("These are the corners the player(s) chose: ", 4);
                                    for (int i = 0; i < options; i++) {
                                        int player = (int) ((Math.random() * 4) + 1);
                                        System.out.print(player + " ");
                                        if (player == itsNumber2) {
                                            choice3--;
                                        }
                                    }
                                    print("");
                                    printAndWait("Choosing...", 4);
                                    print("'It' chose " + itsNumber2);
                                    if (choice3 <= 0) {
                                        print("No one won.");
                                        rounds = 0;
                                    }
                                    if (rounds == x+1 && choice3 > 0) {
                                        print(choice3 + " people won.");
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                } else if (choice4 > 1) {
                    printAndWait("You are now 'it'.", 3);
                    while (rounds > x) {
                        printAndWait("There are currently " +choice3+ " players (excluding 'it') in the game.", 6);
                        int options = choice3;
                        int choice5 = getInputInt("What corner do you pick? Corner 1(1), Corner 2(2), Corner 3(3), or Corner 4(4)");
                        for (int i = 0; i < options; i++) {
                            int player = (int) ((Math.random() * 4) + 1);
                            if (player == choice5) {
                                choice3--;
                            }
                        }
                        if (rounds == x+1 && choice3 > 0) {
                            print("Good attempt. There is/are still "+ choice3+" person/people remaining.");
                            x+=1000;
                        }
                        if (choice3 == 0) {
                            print("You win!");
                            x+=1000;
                        }
                        x++;
                    }
                }
            } else {
                choice3++;
                printAndWait("You are a player.", 3);
                while (choice3 > 1) {
                    printAndWait("There are currently " +choice3+ " players (excluding 'it' and including you) in the game.", 9);
                    int options = choice3;
                    int choice5 = getInputInt("What corner do you pick? Corner 1(1), Corner 2(2), Corner 3(3), or Corner 4(4)");
                    int itsNumber = (int) ((Math.random() * 4) + 1);
                    for (int i = 1; i < options; i++) {
                        int player = (int) ((Math.random() * 4) + 1);
                        if (player == itsNumber) {
                            choice3--;
                        }
                    }
                    printAndWait("Choosing...", 16);
                    print("'It' chose " + itsNumber);
                    if (choice5 != itsNumber && choice5 <= 4 && choice5 >= 1) {
                        printAndWait("Good job! You passed this round.", 6);
                        if (choice3 == 1) {
                            print("You win!");
                        }

                    } else {
                        choice3--;
                        printAndWait("Remaining players left: "+choice3, 4);
                        if (choice3 == 0) {
                            print("Luckily, you got out while everyone else did, therefore, you won!");
                            break;
                        }
                        printAndWait("Good try.", 4);
                        if (choice3 == 1) {
                            print("One of the other players won!");
                        } else {
                            int spectate2 = getInputInt("Do you want to spectate? Yes(1), No(2).");
                            if (spectate2 == 2) {
                                print("Goodbye.");
                                choice3 = 0;
                            } else {
                                while (choice3 > 1) {
                                    printAndWait("There are currently " +choice3+ " players (excluding 'it') in the game.", 4);
                                    options = choice3;
                                    itsNumber = (int) ((Math.random() * 4) + 1);
                                    for (int i = 0; i < options; i++) {
                                        int player = (int) ((Math.random() * 4) + 1);
                                        System.out.print(player + " ");
                                        if (player == itsNumber) {
                                            choice3--;
                                        }
                                    }
                                    print("");
                                    printAndWait("Choosing...", 12);
                                    printAndWait("'It' chose " + itsNumber, 3);
                                    if (choice3 == 1) {
                                        print("One of the other players won.");
                                    } else if (choice3 == 0) {
                                        print(options + " players won due to them getting out at the same time.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            print("Goodbye! Come back when you are avaliable.");
        }
    }
    public static void wait(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(factor * UNIT_WAIT_TIME_MS);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void printAndWait(String msg, int waitFactor) {
        System.out.println(msg);

        wait(waitFactor);
    }

    public static int getInputInt(String prompt) {
        print(prompt);

        return SCANNER.nextInt();
    }

    public static String getInput(String prompt) {
        print(prompt);

        return SCANNER.next();
    }

    public static void setWaitTime() {
        int choice = getInputInt("How fast do you want to go? Enter between 0 to 10 (0 for slowest, 10 for fastest.");

        if (choice >= 10) {
            choice = 10;
        } else if (choice < 0) {
            choice = 0;
        }

        UNIT_WAIT_TIME_MS = 500 - (choice * 50);
    }
}
