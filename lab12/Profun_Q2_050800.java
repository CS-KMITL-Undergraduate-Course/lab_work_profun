class RomanCoin {
    int value;
    String romanNumeral;
    boolean face ;
    private  String intToRoman(int num){
        if(num <1|| num >3999) return "Value Out of Range"; 
        int[] values= {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] symbols= {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
        StringBuilder roman = new StringBuilder();
        int tempNum = num; 
        for (int i = 0; i < values.length; i++){
            while (tempNum >= values[i]){
                roman.append(symbols[i]);
                tempNum -= values[i];
            }
        }
        return roman.toString();
    }
    boolean compareValue(int v){
         return value > v;
    }
    boolean compareValue(RomanCoin other){
        return value > other.value;
    }
    void collide(RomanCoin other){
        other.face= !other.face;
    }
    public  String toString(){
        return "RomanCoin [ Value="+ value +", Roman=" +romanNumeral+" ]";
    }
    int getValue(){
        return value;
    }
    String getRomanNumeral(){
        return romanNumeral;
    }
    public RomanCoin(int val){
        this.value = val;
        this.romanNumeral = intToRoman(val);
        this.face=true;
    }
    public static String toRomanNumeric(int d) {
        if (d < 1 || d > 3999)
            return "Value Out of Range";

        StringBuilder symbol = new StringBuilder();

        while (d >= 1000) {
            symbol.append("M");
            d -= 1000;
        }
        if (d >= 900) {
            symbol.append("CM");
            d -= 900;
        }
        while (d >= 500) {
            symbol.append("D");
            d -= 500;
        }
        if (d >= 400) {
            symbol.append("CD");
            d -= 400;
        }
        while (d >= 100) {
            symbol.append("C");
            d -= 100;
        }
        if (d >= 90) {
            symbol.append("XC");
            d -= 90;
        }
        while (d >= 50) {
            symbol.append("L");
            d -= 50;
        }
        if (d >= 40) {
            symbol.append("XL");
            d -= 40;
        }
        while (d >= 10) {
            symbol.append("X");
            d -= 10;
        }
        if (d >= 9) {
            symbol.append("IX");
            d -= 9;
        }
        while (d >= 5) {
            symbol.append("V");
            d -= 5;
        }
        if (d >= 4) {
            symbol.append("IV");
            d -= 4;
        }
        while (d >= 1) {
            symbol.append("I");
            d -= 1;
        }

        return symbol.toString();

    } 
}

public class ProFun12_Q2_690909{
    static void demo_4() {
        RomanCoin coin2473 = new RomanCoin(2473);
        RomanCoin coin5 = new RomanCoin(5);
        System.out.println(coin2473.getRomanNumeral()); // MMCDLXXIII
        System.out.println(coin2473.getValue()); // 2473
        System.out.println(coin5); // RomanCoin [Value=5, Roman=V]
        System.out.println(coin2473.compareValue(coin5)); // true
        System.out.println(coin5.compareValue(10)); // false
    }

    static void demo_5() {
        RomanCoin coin2473 = new RomanCoin(2473);
        RomanCoin coin5 = new RomanCoin(5);
        coin2473.collide(coin5);
        System.out.println(coin2473);
        System.out.println(coin5);
    }

    static void demo_6() {
        System.out.println(RomanCoin.toRomanNumeric(2473)); // MMCDLXXIII
    }

    public static void main(String[] args) {
        demo_4();
        demo_5();
        demo_6();
    }
}
