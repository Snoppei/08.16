package vsu.negulyaevPavelNikolaevich;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    Storage storage = new Storage();
    SolutionClass logic = new SolutionClass();
    if(needCmd()) runCmd(storage, logic);
    if(needWindow()) winMain();
}
    public static void winMain() {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    private static boolean needCmd() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to use cmd? Enter true/false: ");
        return scanner.nextBoolean();
    }

    private static boolean needWindow() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to use UI? Enter true/false: ");
        return scanner.nextBoolean();
    }

    private static void runCmd(Storage storage, SolutionClass logic) throws IOException {
        CmdCommands cmdCommand = CmdCommands.STATIC;
        Scanner scanner = new Scanner(System.in);

        String command;
        String inputFile;
        String outputFile = "-";
        int[][] arr = new int[][] {
                {3, 4, 9},
                {2, 5, 8},
                {1, 6, 7},
        };
        logic.SumAndSquare(storage, arr);

        System.out.println("Commands:");
        System.out.println("-run     - run program");
        System.out.println("-help    - show commands");
        System.out.println("-exit    - close program");
        System.out.println("-read    - read array from console");
        System.out.println("-input   - enter way to input file");
        System.out.println("-output  - enter way to output file");

        while (cmdCommand != CmdCommands.EXIT) {
            command = scanner.next();
            if (Objects.equals(command, "-run")) {
                cmdCommand = CmdCommands.RUN;
            } else if (Objects.equals(command, "-help")) {
                cmdCommand = CmdCommands.HELP;
            } else if (Objects.equals(command, "-exit")) {
                cmdCommand = CmdCommands.EXIT;
            } else if (Objects.equals(command, "-read")) {
                cmdCommand = CmdCommands.READ_FROM_CONSOLE;
            } else if (Objects.equals(command, "-input")) {
                cmdCommand = CmdCommands.ENTER_INPUT_FILE;
            } else if (Objects.equals(command, "-output")) {
                cmdCommand = CmdCommands.ENTER_OUTPUT_FILE;
            } else {
                System.out.println("Error, this command is not found. Try again: ");
            }

            switch (cmdCommand) {
                case EXIT -> System.exit(1);
                case RUN -> {
                    logic.SumAndSquare(storage, arr);
                    if (!Objects.equals(outputFile, "-")) {
                        ArrayUtils.writeArrayToFile(outputFile, storage.square);
                    }
                    SolutionClass.writeIntArrayToConsole(arr);
                    System.out.println("====================================");
                    SolutionClass.writeIntArrayToConsole(storage.square);
                }
                case READ_FROM_CONSOLE -> {
                    arr = ArrayUtils.readIntArray2FromConsole();
                    printArrayInConsole(arr);
                }
                case ENTER_INPUT_FILE -> {
                    System.out.print("Enter way to input file: ");
                    inputFile = scanner.next();
                    arr = SolutionClass.readIntArray2FromFile(inputFile);
                    printArrayInConsole(arr);

                }
                case ENTER_OUTPUT_FILE -> {
                    System.out.print("Enter way to output file: ");
                    outputFile = scanner.next();
                }
                case HELP -> {
                    System.out.println("Commands:");
                    System.out.println("-run     - run program");
                    System.out.println("-help    - show commands");
                    System.out.println("-exit    - close program");
                    System.out.println("-read    - read array from console");
                    System.out.println("-input   - enter way to input file");
                    System.out.println("-output  - enter way to output file");
                }
            }

        }
    }
    private static void printArrayInConsole(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
