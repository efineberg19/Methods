/**
 * Allows for easier access to processes in the GUI.
 *
 * @author Beth Fineberg
 * @version 1.0
 */
public class MyMethods
{
    /*
     * Four Sum to One
     * 
     * If one integer is equal to the sum of the rest, the method will return true.
     * 
     * @param int a, b, c, d, e
     * @return true or false
     */
    public static boolean fourSumToOne(int a, int b, int c, int d, int e)
    {
        int sumOfAll = a + b + c + d + e;
        int[] numbers = {a, b, c, d, e};
        boolean correct = false;

        for (int i = 0; i < 5; i++)
        {
            if (numbers[i] == (sumOfAll - numbers[i]))
            {
                correct = true;
            }
        }

        return correct;
    }

    /*
     * In Order to Equal
     * 
     * If numbers are given in increasing order, true is returned. Equality is allowed
     * if equalOk is true.
     * 
     * @param int a, b, c, boolean equalOK
     * @return true or false
     */
    public static boolean inOrderToEqual(int a, int b, int c, boolean equalOk)
    {
        boolean correct = false;

        if (equalOk == true)
        {
            if (a <= b && b <= c)
            {
                correct = true;
            }
        }
        if (equalOk == false)
        {
            if (a < b && b < c)
            {
                correct = true;
            }
        }

        return correct;
    }

    /*
     * Should Answer Cell
     * 
     * Tells user if they should answer cell based on their circumstances
     * 
     * @param boolean isMorning, isMom, isAwake
     * @return true or false
     */
    public static boolean shouldAnswerCell(boolean isMorning, boolean isMom, boolean isAsleep)
    {
        boolean correct = false;

        if (!isMorning && !isMom && !isAsleep)
        {
            correct = true;
        }
        if (!isMorning && !isMom && isAsleep)
        {
            correct = false;
        }
        if (isMorning && !isMom && !isAsleep)
        {
            correct = false;
        }

        return correct;
    }

    /*
     * Full Web
     * 
     * Completes web address given by user.
     * 
     * @param String webName
     * @return String with full web address
     */
    public static String fullWeb (String webName)
    {
        if (webName.indexOf(".") == -1)
        {
            return "Bad web address";
        }
        else if (webName.substring(0, 3).equals("www."))
        {
            return "http://" + webName;
        }
        else if(webName.substring(0, 6).equals("http://"))
        {
            return webName;
        }
        else
        {
            return "http://www." + webName;
        }
    }

    public static int stringNumberSum(String input)
    {
        int sum = 0;
        for (int i = 0; i < input.length(); i ++)
        {
            if (Integer.parseInt(input.charAt(i) + "") >= 0 || Integer.parseInt(input.charAt(i) + "") <= 9)
            {
                sum += Integer.parseInt(input.charAt(i) + "");
            }
        }
        return sum;
    }

    /*
     * Can Move
     * 
     * Tells user if their character can move based on their given circumstances.
     * 
     * @param boolean Nblocked, Sblocked, Eblocked, Wblocked, int power, char direction
     * @return true or false
     */
    public static boolean canMove(boolean Nblocked, boolean Sblocked, boolean Eblocked, 
    boolean Wblocked, int power, char direction)
    {
        if ((power > 15) && !Nblocked && (direction == 'N'))
        {
            return true;
        }
        else if ((power > 15) && !Sblocked && (direction == 'S'))
        {
            return true;
        }
        else if ((power > 15) && !Eblocked && (direction == 'E'))
        {
            return true;
        }
        else if ((power > 15) && !Wblocked && (direction == 'W'))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * Formula
     * 
     * Gives user an integer using a specific formula based upon their input.
     * 
     * @param int x, y, z
     * @return int formula result
     */
    public static int formula (int x, int y, int z)
    {
        if (x == y)
        {
            return (2 * (x + z));
        }
        else if (z % x == 0)
        {
            return (x * y * z);
        }
        else
        {
            return (99 * x - 10 * y + z);
        }
    }

    /*
     * Get Ticket
     * 
     * Gives user a ticket orice depending upon their speed and if it's their birthday.
     * 
     * @param int speed, boolean birthday
     * @return int ticket price
     */
    public static int getTicket(int speed, boolean isBirthday)
    {
        int q = 0;

        if (isBirthday)
        {
            speed = speed - 10;
        }
        if (speed <= 60)
        {
            q = 0;
        }
        if ((speed > 61) && (speed <= 80))
        {
            q = (2 * speed);
        }
        else if (speed >= 81)
        {
            q = (3 * speed);
        }

        return q;
    }

    /*
     * Get Ticket (Accurate)
     * 
     * Gives user a ticket price based on the actual rules of the RMV. The zone type
     * and speed limit will dictate the price
     * 
     * @param int speed, String zone 
     * @return int ticket price
     */
    public static int getTicketAccurate(int speed, String zone) 
    {
        int speedLimit = 65; 

        if (zone.equals("School Zone"))
        {
            speedLimit = 20;
        }
        if (zone.equals("Bussiness"))
        {
            speedLimit = 30;
        }
        if (zone.equals("Undivided Highway"))
        {
            speedLimit = 40;
        }
        if (zone.equals("Divided Highway"))
        {
            speedLimit = 50;
        }

        if (speed > speedLimit) //calculates ticket price
        {
            if (speed > 10 + speedLimit)
            {
                int over = speed - speedLimit - 10; //first 10 mph over limit is $105
                int extra = 10 * over; //extra $10 for each mph over limit
                return (105 + extra);
            }
            else
            {
                return 105;
            }
        }
        else
        {
            return 0;
        }
    }
    
    /*
     * Elemental Family
     * 
     * User provides atomic number and program returns which family an element belongs to.
     * 
     * @param int aNumber
     * @return String elemental family
     */
    public String elementalFamily(int aNumber)
    {
        if ((aNumber == 1) || ((aNumber >= 6) && (aNumber <= 8)) || (aNumber == 15) || (aNumber == 16) || (aNumber == 34))
        {
            return "non metal";
        }
        else if ((aNumber == 3) || ((aNumber >= 11) || (aNumber >= 19)) || (aNumber >= 37) || (aNumber >= 55) || (aNumber >= 87))
        {
            return "alkali metal";
        }
        else if ((aNumber == 4) || (aNumber == 12) || (aNumber == 20) || (aNumber == 38) || (aNumber == 56) || (aNumber == 88))
        {
            return "alkaline earth metal";
        }
        else if ((aNumber == 2) || (aNumber == 10) || (aNumber == 18) || (aNumber == 36) || (aNumber == 10) || (aNumber == 54) || (aNumber == 86))
        {
            return "noble gas";
        }
        else if ((aNumber == 9) || (aNumber == 17) || (aNumber == 35) || (aNumber == 53) || (aNumber == 85))
        {
            return "halogen";
        }
        else if ((aNumber == 5) || (aNumber == 14) || (aNumber == 32) || (aNumber == 33) || (aNumber == 51) 
        || (aNumber == 52) || (aNumber == 84))
        {
            return "metalloid";
        }
        else if(((aNumber >= 21) && (aNumber <= 30)) || ((aNumber >= 39) && (aNumber <= 48)) || 
        ((aNumber >= 72) && (aNumber <= 80)) || ((aNumber >= 104) && (aNumber <= 112)))
        {
            return "transition metal";
        }
        else if((aNumber == 13) || (aNumber == 31) || (aNumber == 49) || (aNumber == 50) || ((aNumber >= 81) 
            && (aNumber <= 83)) || (aNumber == 114))
        {
            return "metal";
        }
        else if((aNumber >= 57) && (aNumber <= 71))
        {
            return "lanthanide";
        }
        else if((aNumber >= 89) && (aNumber <= 103))
        {
            return "actinide";
        }
        else if((aNumber == 113) || (aNumber >= 115) && (aNumber <= 118))
        {
            return "unknown";
        }
        else
        {
            return "Error: not a valid atomic number";
        }
    }

    /*
     * Periodic Table Row
     * 
     * User provides atomic number and program returns which row the element is in.
     * 
     * @param int aNumber
     * @return int row number
     */
    public int periodicTRow(int aNumber)
    {
        if ((aNumber == 1) || (aNumber == 2))
        {
            return 1;
        }
        else if ((aNumber >= 3) && (aNumber <= 10))
        {
            return 2;
        }
        else if ((aNumber >= 11) && (aNumber <= 18))
        {
            return 3;
        }
        else if((aNumber >= 19) && (aNumber <= 36))
        {
            return 4;
        }
        else if((aNumber >= 37) && (aNumber <= 54))
        {
            return 5;
        }
        else if((aNumber >= 55) && (aNumber <= 86))
        {
            return 6;
        }
        else if((aNumber >= 87) && (aNumber <= 118))
        {
            return 7;
        }
        else
        {
            return 0;
        }
    }

    /*
     * Three Points Info
     * 
     * Takes coordinates of three points and either returns area of triangle formed by
     * them or the longest distance between the two points (if they're on the same line).
     * This was working yesterday but it stopped working. The math checks out so I'm not
     * sure what is happening.
     * 
     * @param x1, y1, x2, y2, x3, y3
     * @return length between points or area of triangle
     * 
     */
    public double threePtsInfo(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        if ((y1 - ((y2 - y1)/(x2 - x1)) * x1) == (y3 - ((y2 - y1)/(x2 - x1)) * x3))
        {
            double segment1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            double segment2 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
            double segment3 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

            double biggerSegment = 0;

            if ((segment1 > segment2) && (segment1 > segment3))
            {
                biggerSegment = segment1;
            }
            else if ((segment2 > segment1) && (segment2 > segment3))
            {
                biggerSegment = segment2;
            }
            else if ((segment2 > segment1) && (segment2 > segment3))
            {
                biggerSegment = segment2;
            }

            return biggerSegment;
        }
        else
        {
            double value = ((-1 / 2) * Math.abs(x1 * y2 - x2 * y1 + x2 * y3 - x3 * y2 + x3 * y1 - x1 * y3));
            return value;
        }
    }

    /*
     * Sum of Threes
     * 
     * User provides a number and program returns that number represented as a String
     * of factors of three added together.
     * 
     * @param int n
     * @return String sum of factors of three
     */
    public String sumOfThrees(int n)
    {
        int e = (int)(Math.log(n)/Math.log(3));
        int r = n;
        String result = "";

        for(int i = e; i >= 0; i--)
        {
            if ((r - 3^i) > 0)
            {
                r = r - 3^i;
                result = r + " + ";
            }
        }

        return result;
    }
}
