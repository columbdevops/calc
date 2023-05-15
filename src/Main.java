import java.io.IOException;
import java.util.*;
//import java.util.Scanner;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение: ");

        String stringInput = scanner.nextLine();
        if (stringInput != "") {
            String result = calc(stringInput);
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Вы ничего не ввели!");
        }
    }

    static String calc(String input) {
        // разделения строки на подстроки на основе определенных символов  с сохранением самого символов
        String[] dataArr = input.split("(?=[+\\-*/])|(?<=[+\\-*/])");

        if(dataArr.length != 3){
            return "Вы должны ввести математическое выражение: с двумя операндами и арифметическим оператором между ними .";
        }
        for (int i = 0; i < dataArr.length; i++) {
            //уберём все пробелы
            dataArr[i] = dataArr[i].trim();
        }

        if(dataArr[0].contains(",") || dataArr[2].contains(",") ){
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Операнды должны быть целыми числами.";
            }
        }

        Map<String, Integer> rimNumbersMap = new HashMap<>();
        rimNumbersMap.put("C", 100);
        rimNumbersMap.put("XC", 90);
        rimNumbersMap.put("L", 50);
        rimNumbersMap.put("XL", 40);
        rimNumbersMap.put("X", 10);
        rimNumbersMap.put("IX", 9);
        rimNumbersMap.put("V", 5);
        rimNumbersMap.put("IV", 4);
        rimNumbersMap.put("I", 1);

        Integer operand1 = 0;
        Integer operand2 = 0;
        //является ли операнд римской true или арабской false цифрой
        boolean  containsOperand1 = false;
        boolean  containsOperand2 = false;

        for (String key : rimNumbersMap.keySet()) {
            // На этом этапе нас интересует только значения < или = 10 так как операранды должны быть от 1 - 10
            if(rimNumbersMap.get(key) < 11){

                //сравниваем ключ из массива с операндом1, если совпадают получаем эквивалент арабского числа
                if(dataArr[0].equals(key)) {
                    containsOperand1 = true;
                    operand1 = rimNumbersMap.get(key);

                }else{
                    // Если значение не совпало, то мы вынуждены проверить есть ли римская цифра не указанная в массиве rimNumbersMap
                    if(!containsOperand1){
                        operand1 = getInt(rimNumbersMap.get(key), key, dataArr[0]);
                        if(operand1 != 0){
                            containsOperand1 = true;
                        }
                    }
                }

                if(dataArr[2].equals(key)) {
                    containsOperand2 = true;
                    operand2 = rimNumbersMap.get(key);

                }else{
                    if(!containsOperand2) {
                        operand2 = getInt(rimNumbersMap.get(key), key, dataArr[2]);
                        if(operand2 != 0){
                            containsOperand2 = true;
                        }
                    }
                }
            }
        }

        boolean checkRimCount = false;
        if (containsOperand1 && containsOperand2) {
            checkRimCount = true;
        } else {
            try {
                operand1 = Integer.parseInt(dataArr[0]);
                operand2 = Integer.parseInt(dataArr[2]);
            } catch (NumberFormatException e) {
                return "Операнды должны быть целыми числами.";
            }
        }

        if (operand1 == 0 || operand2 == 0 || operand1 > 10 || operand2 > 10) {
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Числа должны быть от 1 до 10 включительно!";
            }
        }

        Integer result;
        switch (dataArr[1]) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new UnsupportedOperationException();
                // return "Неподдерживаемая операция.";
        }

        if(checkRimCount) {  // Преобразование результата в римскую цифру
            if(result < 1){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    return "В римких цифрах нет 0 и отрицательных значений.";
                }

            }
            String new_res = "";
            while (result >= 1) { // в цикле пока result может иметь положительное значение
                String maxStrRes = "";
                Integer maxInRes = 0;

                for (String key : rimNumbersMap.keySet()) {
                    if(rimNumbersMap.get(key) == result){ // если у нас цифра, значение которой есть в массиве rimNumbersMap
                        if(new_res == ""){
                            return  String.valueOf(key );
                        }
                        new_res +=  key;
                        result -= rimNumbersMap.get(key);
                        if(result == 0){
                            return  new_res;
                        }
                    }else{
                        if(rimNumbersMap.get(key) < result && maxInRes < rimNumbersMap.get(key)){ // ищем max значение, которое может быть
                            maxInRes = rimNumbersMap.get(key);
                            maxStrRes = key;
                        }
                    }
                }
                new_res +=  maxStrRes;
                result -= maxInRes;
            }
            return  new_res;
        }else{
            return String.valueOf(result);
        }
    }

    static Integer getInt(Integer rimNumbersMap, String key, String data){
        String var = key;
        for (Integer i = 1; i < 4; i++) {
            var += "I";
            if (var.equals(data)) {
                return (rimNumbersMap + i);
            }
        }

        // Если введенное значение является римской цифрой, но не содержится в rimNumbersMap
        try {
            throw new IOException();
        } catch (IOException e) {
            return 0;
        }
    }
}