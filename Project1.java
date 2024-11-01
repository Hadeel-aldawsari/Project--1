import java.util.*;

public class Project1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Let's take a funny break \uD83D\uDE0E\nEnter your name:");
        String name = input.nextLine();
        System.out.println("Good luck " + name + "\uD83D\uDCAA");
        System.out.println("How many round do you want to play?\n1-one round\n2-three round");

        int roundOption;
        while (true){
            try {
                System.out.print("Enter option number:");
                roundOption = input.nextInt();
                if(roundOption==1 || roundOption==2){
                    break;
                }else throw new InputMismatchException("!");
            }catch (InputMismatchException e){
                System.out.print("Invalid input! Please enter 1 or 2 ");
            }
        }

       // input.nextDouble();

        if(roundOption==2)roundOption=3;

        String[] roundArray=new String[roundOption] ;

      //  ArrayList<String> roundArray =new ArrayList();


        String[][] matrix=  {
                {"  1 ","  2  ","  3 " },
                {"  4 ","  5  ","  6 " },
                {"  7 ","  8  ","  9 " }
        };



        boolean win=false;
        int num;
        int round=1;
        String player = CheckXorO(input);

        while(round<=roundArray.length) {
            print(matrix);
            do {
                System.out.print("Chose Position number:");
                num = input.nextInt();
                switch (num) {
                    case 1:
                        if (!matrix[0][0].contains("⭕") && !matrix[0][0].contains("✖\uFE0F")) {
                            matrix[0][0] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }

                    case 2:
                        if (!matrix[0][1].contains("⭕") && !matrix[0][1].contains("✖\uFE0F")) {
                            matrix[0][1] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 3:
                        if (!matrix[0][2].contains("⭕") && !matrix[0][2].contains("✖\uFE0F")) {
                            matrix[0][2] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 4:
                        if (!matrix[1][0].contains("⭕") && !matrix[1][0].contains("✖\uFE0F")) {
                            matrix[1][0] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 5:
                        if (!matrix[1][1].contains("⭕") && !matrix[1][1].contains("✖\uFE0F")) {
                            matrix[1][1] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 6:
                        if (!matrix[1][2].contains("⭕") && !matrix[1][2].contains("✖\uFE0F")) {
                            matrix[1][2] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 7:
                        if (!matrix[2][0].contains("⭕") && !matrix[2][0].contains("✖\uFE0F")) {
                            matrix[2][0] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen:");
                            continue;
                        }
                    case 8:
                        if (!matrix[2][1].contains("⭕") && !matrix[2][1].contains("✖\uFE0F")) {
                            matrix[2][1] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                    case 9:
                        if (!matrix[2][2].contains("⭕") && !matrix[2][2].contains("✖\uFE0F")) {
                            matrix[2][2] = player;
                            break;
                        } else {
                            System.out.println("Please Enter a number that has not been chosen");
                            continue;
                        }
                }//end switch
                print(matrix);

                if (isFull(matrix) >= 4) {
                    if (!winnerValidation(matrix, player).isEmpty()) {
                        System.out.println(winnerValidation(matrix, player));
                        win = true;
                        if(winnerValidation(matrix, player).contains("won"))roundArray[round-1]="Player";
                        if(winnerValidation(matrix, player).contains("draw"))roundArray[round-1]="Draw";
                        matrix=reset();
                        round++;
                        break;
                    }
                }

                if (isFull(matrix) <= 9 && !win) {
                    randomPlayer(matrix, player);
                    if (!winnerValidation(matrix, player).isEmpty()) {
                        System.out.println(winnerValidation(matrix, player));
                        win = true;
                        if(winnerValidation(matrix, player).contains("loose"))roundArray[round-1]="Random";
                        if(winnerValidation(matrix, player).contains("draw"))roundArray[round-1]="Draw";
                        matrix=reset();
                        round++;
                        break;
                    }
                }

            } while (isFull(matrix) < 9);




        if(round>1 && round<4 && roundArray.length!=1 ){
            System.out.println("");
            System.out.println("****** \uD83D\uDD25 \uD83D\uDD25 Round "+round+" \uD83D\uDD25 \uD83D\uDD25 ******");
            System.out.println("");
            reset();
              win=false;}
        }
        if(roundArray.length!=1) {
            System.out.println("");
            System.out.println("***** \uD83D\uDEA9 Final Result \uD83D\uDEA9 *****");
            System.out.println("Round | Winner");
            System.out.println("------------------------");
            int w_player = 0;
            int w_random = 0;
            for (int i = 0; i < roundArray.length; i++) {
                String winner = roundArray[i] != null ? roundArray[i] : "draw";
                if (roundArray[i].equals("Player")) w_player++;
                if (roundArray[i].equals("Random")) w_random++;
                System.out.printf("  %d   | %s%n", i + 1, winner);
            }
            System.out.println("------------------------");
            if (w_player > w_random) {
                System.out.println("Congratulations " + name + " \uD83C\uDF89");
            } else if (w_random > w_player) {
                System.out.println("Game Over " + name + " ☹\uFE0F");
            }else System.out.println("Drawn players !");
        }else {
            if(roundArray[0].equals("Player")) {
                System.out.println("Congratulations " + name + " \uD83C\uDF89");
                System.out.println("&&&&&&&&&&&&&&&&"+roundArray[0]);
            }else if(roundArray[0].equals("Random")){
                System.out.println("Game Over " + name + " ☹\uFE0F");
            }else System.out.println("Drawn players !");
        }
    }//end main










        public static String[][] reset() {
             String[][] origin_matrix = {
                     {"  1 ","  2  ","  3 " },
                     {"  4 ","  5  ","  6 " },
                     {"  7 ","  8  ","  9 " }
             };
             return origin_matrix;
        }


    public static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != 2)
                    System.out.print("|");
            }
            System.out.println("");
            //System.out.println("____________");
        }
    }

    public static int isFull(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].contains("✖\uFE0F") || matrix[i][j].contains("⭕"))
                    count++;
            }
        }
        return count;
    }

    public static void randomPlayer(String[][] matrix, String player) {
        String randomPlayer = "";
        if (player.contains("✖\uFE0F")) {
            randomPlayer = " ⭕ ";
        } else randomPlayer = " ✖\uFE0F ";

        Random random = new Random();
        boolean looking = true;
        int randomInt = 0;
        while (looking) {
            randomInt = random.nextInt(9 - 1) + 1;
            switch (randomInt) {
                case 1:
                    if (!matrix[0][0].contains(player) && !matrix[0][0].contains(randomPlayer)) {
                        matrix[0][0] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }

                case 2:
                    if (!matrix[0][1].contains(player) && !matrix[0][1].contains(randomPlayer)) {
                        matrix[0][1] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (!matrix[0][2].contains(player) && !matrix[0][2].contains(randomPlayer)) {
                        matrix[0][2] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (!matrix[1][0].contains(player) && !matrix[1][0].contains(randomPlayer)) {
                        matrix[1][0] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (!matrix[1][1].contains(player) && !matrix[1][1].contains(randomPlayer)) {
                        matrix[1][1] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (!matrix[1][2].contains(player) && !matrix[1][2].contains(randomPlayer)) {
                        matrix[1][2] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (!matrix[2][0].contains(player) && !matrix[2][0].contains(randomPlayer)) {
                        matrix[2][0] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!matrix[2][1].contains(player) && !matrix[2][1].contains(randomPlayer)) {
                        matrix[2][1] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (!matrix[2][2].contains(player) && !matrix[2][2].contains(randomPlayer)) {
                        matrix[2][2] = randomPlayer;
                        looking = false;
                        break;
                    } else {
                        break;
                    }
            }

        }//end while
        System.out.println("Random Player("+ randomPlayer +") chose:"+ randomInt);
        print(matrix);
    }

    public static String CheckXorO(Scanner input) {
        String player;
        input.nextLine();
        while (true) {
            System.out.print("Chose X or O:");
            player = input.nextLine();
            if (player.equals("o") || player.equals("O") ) {
                player = " ⭕ ";
                return player;
            }if(player.equals("X") || player.equals("x")) {
                player = " ✖\uFE0F ";
                return player;
            } else {
                System.out.println("Please enter valid input");
                continue;
            }
        }
    }

    public static String winnerValidation(String[][] matrix, String player) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                if (matrix[i][0].contains(player)) {
                    return "Good job you Won";
                } else{

                    return "you loose :(";
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                if (matrix[0][i].contains(player)) {
                    return "Good job you won";
                } else{
                    return "you loose :(";
                }
            }

        }

        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] ) {
            if (matrix[0][0].contains(player)) {
                return "Good job you won";
            } else{
                return "you loose :(";
            }
        }

        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] ) {
            if (matrix[0][2].contains(player)) {
                return "Good job you won";
            } else{
                return "you loose :(";
            }
        }
        if (isFull(matrix) == 9) {
            return "It's a draw!";
        }
        return "";
    }



}




