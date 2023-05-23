package methods;

public class Plus {
    ErrorText errorText = new ErrorText();
    public String createPlus(String  stringInput){
        //разделяем на массив по знакам
        String[] dataArr = stringInput.split("(?<=\")\\s*(?=[+\\-*/])|(?<=[+\\-*/])\\s*(?=\")");
        if(dataArr.length != 3){
            return "error3:\n" + errorText.errorText();
        }

        //убираем кавычки
        CleanOperand clearQuotes = new CleanOperand();
        for(int i = 0; i < dataArr.length; i = i + 2){
            dataArr[i] = clearQuotes.clean(dataArr[i]);

            //проверяем более ли 10ти символов в каждом операнде
            CheckData checkData = new CheckData();
            if(!checkData.checkMaxSymbol(dataArr[i])) {
                return "error10:\nКаждый операнд не должен быть более 10 символов или возможно у вас другая ошибка\n" + errorText.errorText();
            }
        }
        return dataArr[0] + dataArr[2];
    }
}
