package com.company;

public class Calc {
    String text, res;
    boolean rim = false;
    public void GetResult(){
        if(CheckText(text)) {
            if(CheckRim(text)) {
                ChangeRim(text);
                rim = true;
            }
            res=StringToIntGetResult(text);

            if(rim){
                if(Integer.parseInt(res)>0)
                    System.out.println(GetRim(res));
                else
                    Error();
            }else
                System.out.println(res);
        }
        else
            Error();


    }
    private boolean CheckText(String str) { //  С помощью регулярного выражения проверям выражение из целых чисел
        String reg = "(^([1-9]|10)(\\+|\\-|\\/|\\*)([1-9]|10)$)|(^(I|II|III|IV|V|VI|VII|VIII|IX|X)(\\+|\\-|\\/|\\*)(I|II|III|IV|V|VI|VII|VIII|IX|X)$)";
        if (str.matches(reg))
            return true;
        else
           return false;
    }
    private boolean CheckRim(String str){   //  С помощью регулярного выражения проверям выражение из римских чисел
        String reg ="^(I|II|III|IV|V|VI|VII|VIII|IX|X)(\\+|\\-|\\/|\\*)(I|II|III|IV|V|VI|VII|VIII|IX|X)$";
        if (str.matches(reg))
            return true;
        else
            return false;

    }
    private void ChangeRim(String str){
        String[] arrRim = new String[]{"VIII", "VII", "VI", "IV", "V", "IX", "X", "III", "II", "I"};
        String[] arrArab = new String[]{"8", "7", "6", "4", "5", "9", "10", "3", "2", "1"};

        for (int i=0; i<arrRim.length; i++){
            str = str.replace(arrRim[i], arrArab[i]);
        }
        text = str;
    }
    private String StringToIntGetResult(String str){
        int result = 0;

        String[] arrArif = new String[]{"*", "/", "+", "-"};
        String a="";
        String[] arrChisla = new String[2];
        for(int i=0; i<arrArif.length; i++){
            arrChisla = str.split("\\"+arrArif[i]);
                    if(arrChisla.length>1) {
                        a = arrArif[i];
                        break;
                    }
            }

        int n1 = Integer.parseInt(arrChisla[0]);
        int n2 = Integer.parseInt(arrChisla[1]);

        if(a == "+")
            result = n1+n2;
        if(a == "-")
            result = n1-n2;
        if(a == "/")
            result = n1/n2;
        if(a == "*")
            result = n1*n2;

        return Integer.toString(result);

    }
    private String GetRim(String str){
        int res = Integer.parseInt(str);
        if(res<10)
            return GetRim_OneNine(str);
        else if(res % 10 == 0)
            return GetRim_ZeroEnd(str);
        else
            return GetRim_Other(str);
    }
    private String GetRim_OneNine(String str){
        String[] arrRim = new String[]{"VIII", "VII", "VI", "IV", "V", "IX", "X", "III", "II", "I"};
        String[] arrArab = new String[]{"8", "7", "6", "4", "5", "9", "10", "3", "2", "1"};
        for (int i=0; i<arrRim.length; i++){
            str = str.replace(arrArab[i], arrRim[i]);
        }
        return str;
    }
    private String GetRim_ZeroEnd(String str){
        String[] arrRim = new String[]{"LXXX", "LXX", "LX", "XL", "L", "XC", "C", "XXX", "X", "X"};
        String[] arrArab = new String[]{"80", "70", "60", "40", "50", "90", "100", "30", "20", "10"};
        for (int i=0; i<arrRim.length; i++){
            str = str.replace(arrArab[i], arrRim[i]);
        }
        return str;
    }
    private String GetRim_Other(String str){
        return GetRim_ZeroEnd(str.charAt(0)+"0") + GetRim_OneNine(str.charAt(1)+"");

    }
    private void Error() {
        System.err.println("Exception");
    }
}
