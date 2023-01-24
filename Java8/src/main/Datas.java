package main;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2022, Month.JUNE, 5);

        int anos = olimpiadasRio.getYear() - hoje.getYear();
        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo.getDays());

        var proximasOlimpiadas = olimpiadasRio.plusYears(4);

        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        var valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);

        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorHora));

        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);
    }
}
