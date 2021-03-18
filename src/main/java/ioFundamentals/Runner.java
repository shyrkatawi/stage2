package ioFundamentals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Реализовать программу которая будет получать в качестве аргумента командной строки
 * путь к директории, например "D:/movies".
 * Записать в текстовый файл структуру папок и файлов в виде,
 * похожем на выполнение программы tree /F.
 * <p>
 * Если в качестве параметра в программу передается не путь к директории,
 * а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
 * Количество папок
 * Количество файлов
 * Среднее количество файлов в папке
 * Среднюю длинну названия файла
 */
public class Runner {
    public static void main(String[] args) {
        String path = args[0].replace("/", "\\");
//        String path = "E:\\tmp\\";
//        String path = "E:\\output.txt";
        if (path.endsWith(".txt")) {
            readFile(path);
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\output.txt"))) {
                writeStructureOfDirectory(writer, new File(path), "");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeStructureOfDirectory(BufferedWriter writer, File f, String space) throws IOException {
        final String spaceExample = "——";
        for (File tmpFile : f.listFiles()) {
            StringBuilder sb = new StringBuilder();
            sb.append(space);
            sb.append(tmpFile.getName());
            if (tmpFile.isDirectory()) {
                sb.append("(dir)");
            }
            sb.append("\n");
            writer.write(sb.toString());
            if (tmpFile.isDirectory()) {
                writeStructureOfDirectory(writer, tmpFile, space + spaceExample);
            }
        }
    }

    private static void readFile(String path) {
        try {
            int directoryCounter = 0;
            int fileCounter = 0;
            int sumOfFileNamesLength = 0;
            for (String line : Files.readAllLines(Paths.get(path))) {
                if (line.endsWith("(dir)")) {
                    directoryCounter++;
                } else {
                    fileCounter++;
                    sumOfFileNamesLength += line.replaceAll("—", "").length();
                }
            }
            System.out.println(directoryCounter);
            System.out.println(fileCounter);
            System.out.println((double)directoryCounter/fileCounter);
            System.out.println((double)sumOfFileNamesLength/fileCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


