import javax.swing.*;

/**
 * Created by Andrew on 12/9/2014.
 */
public class PhonePhy extends JFrame{
    public static void main(String[] args)
    {
        new PhonePhy();
    }
    SQLAPI sqlapi = new SQLAPI("173.52.70.126","root","password",3306,"phone_numbers");
    int currentAreaCode = 200;
    boolean done = false;
    public PhonePhy()
    {
        setBounds(0,0,100,100);
        try
        {
            while(sqlapi.isClaimed(currentAreaCode) && currentAreaCode<=999)
            {
                currentAreaCode++;

            }
            sqlapi.claimAreaCode(currentAreaCode);
        }catch(Exception ex){}
        begin();

    }
    public void begin()
    {


            for(int i = 100; i<=999; i++)
            {
                for(int c = 1000; c<=9999; c++)
                {
                    try
                    {
                     //   System.out.print(currentAreaCode + "-" + i + "-" + c + "\n");
                        sqlapi.addPhoneNumber(currentAreaCode, i, c);
                    }catch(Exception ex){}

                }
            }


    }

}
