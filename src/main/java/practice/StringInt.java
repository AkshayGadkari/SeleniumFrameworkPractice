package practice;

public class StringInt {

    public static void main(String[] args) {

        String str = "Hello";
        String stri= "200";
        int i=10;


        //String to integer Conversion
        try {
            System.out.println("Integer.parseInt(str) = " + Integer.parseInt(str));
        }
        catch(NumberFormatException nfe)
        {
            System.out.println(nfe);
            nfe.printStackTrace();
        }


        System.out.println("Integer.parseInt(stri) = " + Integer.parseInt(stri));


        //integer to String Conversions
        String is =Integer.toString(i);

        System.out.println(is);
        System.out.println("ok");

    }
}
