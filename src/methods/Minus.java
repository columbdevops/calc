package methods;


public class Minus {
    public String createMinus(String stringInput) {
        ErrorText errorText = new ErrorText();
        //разделяем на массив по знакам
        String[] dataArr = stringInput.split("\"\\s*-\\s*\"");
        if (dataArr.length != 2) {
            return "error9";
        }

        //удаляем 1ю кавычку
        dataArr[0] = dataArr[0].substring(1);
        String dataArr1 = dataArr[1];
        int lastIndex = dataArr1.length() - 1;
        //удаляем 2ю кавычку
        String modifiedDataArr1 = dataArr1.substring(0, lastIndex);
        dataArr[1] = modifiedDataArr1;

        //проверяем более ли 10ти символов в каждом операнде
        CheckData checkData = new CheckData();
        if(!checkData.checkMaxSymbol(dataArr[0]) || !checkData.checkMaxSymbol(dataArr[1])) {
            return "error10.2:\nКаждый операнд не должен быть более 10 символов или возможно у вас другая ошибка\n" + errorText.errorText();
        }

        return dataArr[0].replace(dataArr[1], "");

    }
}
