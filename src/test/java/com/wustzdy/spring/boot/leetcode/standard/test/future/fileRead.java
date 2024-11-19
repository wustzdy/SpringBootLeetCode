package com.wustzdy.spring.boot.leetcode.standard.test.future;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class fileRead {
    public static void main(String[] args) {
        String inputFilePath = "/Users/zhudayang/zdyWork/SpringBootLeetCode/src/test/java/com/wustzdy/spring/boot/leetcode/standard/test/future/suanfa.txt";
        String outputFilePath = "/Users/zhudayang/zdyWork/SpringBootLeetCode/src/test/java/com/wustzdy/spring/boot/leetcode/standard/test/future/output.xlsx";
        // 创建一个工作簿和工作表
        // 创建一个工作簿和工作表
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Dependencies");

            // 创建表头行
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("序号");
            headerRow.createCell(1).setCellValue("包名");
            headerRow.createCell(2).setCellValue("版本号");

            // 读取文本文件内容
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            int rowNum = 1; // 从第二行开始写入内容
            for (String line : lines) {
                // 按 "==" 分割每一行的内容
                if(line.contains("==")) {
                    String[] parts = line.split("==");

                    if (parts.length == 2) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(rowNum - 1); // 序号
                        row.createCell(1).setCellValue(parts[0]);   // 包名
                        row.createCell(2).setCellValue(parts[1]);   // 版本号
                    }
                }
            }

            // 将内容写入 Excel 文件
            try (FileOutputStream fileOut = new FileOutputStream(outputFilePath)) {
                workbook.write(fileOut);
            }

            System.out.println("Excel文件已成功创建，路径: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
