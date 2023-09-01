package org.mtmuniz;

import com.sun.management.OperatingSystemMXBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();

        double totalCpuTime = 0.0;
        double totalCpuLoad = 0.0;
        long totalMemoryUsed = 0;

        try {
            String inputFilePath = Objects.requireNonNull(encrypt.class.getClassLoader().getResource("input.txt")).getPath();
            String outputFileName = "outputRailFence.txt";

            File inputFile = new File(inputFilePath);
            String outputFilePath = new File(inputFile.getParent(), outputFileName).getPath();

            Scanner scanner = new Scanner(new File(inputFilePath));

            for (int i = 0; i < 10; i++) {
                long startTime = System.nanoTime(); // Captura o tempo inicial

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().toUpperCase();
                    String encrytedLine = encrypt.encrypt(line);
                    text.append(encrytedLine).append(System.lineSeparator());
                }
                scanner.close();
                scanner = new Scanner(new File(inputFilePath));

                long endTime = System.nanoTime(); // Captura o tempo final
                long elapsedTime = endTime - startTime; // Calcula o tempo decorrido em nanossegundos
                double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000; // Converte para segundos
                System.out.println("Tempo de CPU: " + elapsedTimeInSeconds + " segundos");
                totalCpuTime += elapsedTimeInSeconds;

                OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
                double cpuLoad = osBean.getProcessCpuLoad() * 100; // Valor de 0.0 a 1.0
                System.out.println("Uso de CPU: " + cpuLoad + "%");
                totalCpuLoad += cpuLoad;

                Runtime runtime = Runtime.getRuntime();
                long usedMemory = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Uso de memória: " + usedMemory + " bytes");
                totalMemoryUsed += usedMemory;
                System.out.println("\n");
            }

            double averageCpuTime = totalCpuTime / 10;
            double averageCpuLoad = totalCpuLoad / 10;
            long averageMemoryUsed = totalMemoryUsed / 10;

            System.out.println("Média do tempo de CPU: " + averageCpuTime + " segundos");
            System.out.println("Média do uso de CPU: " + averageCpuLoad + "%");
            System.out.println("Média do uso de memória: " + averageMemoryUsed + " bytes");
            System.out.println("\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(text.toString());
            writer.close();

            System.out.println("Criptografado e escrito em " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}