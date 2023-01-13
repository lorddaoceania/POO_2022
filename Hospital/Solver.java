import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Solver {

    // Complete the solve function below.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        // Read the number of commands
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            List<String> ui = Arrays.asList(line.split(" "));
            if (ui.get(0).equals("end")) {
                break;
            } else if (ui.get(0).equals("addPacs")) {
                ui.stream().skip(1)
                        .forEach(tk -> hospital.addPaciente(new Paciente(tk.split("-")[0], tk.split("-")[1])));
            } else if (ui.get(0).equals("addMeds")) {
                ui.stream().skip(1).forEach(tk -> hospital.addMedico(new Medico(tk.split("-")[0], tk.split("-")[1])));
            } else if (ui.get(0).equals("show")) {
                System.out.print(hospital.toString());
            } else if (ui.get(0).equals("tie")) {
                ui.stream().skip(2).forEach(name -> hospital.vincular(ui.get(1), name));
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}