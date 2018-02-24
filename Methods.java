
public class Methods
{
    /**
     * VERY SILLY METHOD FOR TESTING PURPOSES: adds 2 words to make one
     * @param word1 the first word
     * @param word2 the second word
     * @return the two words reversed and concatenated
     */
    public String combine(String word1, String word2)
    {
        return word2 + " " + word1;
    }
    /**
     * EQUALLY SILLY METHOD FOR TESTING PURPOSES:
     * @param test1 meangingless boolean
     * @param age age of the user in years
     * @param favNum favorite number of the user
     * @return true is passes my silly test; false otherwise
     */
    public boolean testing(boolean test1, int age, int favNum)
    {
        if(test1 && age < 7 || favNum == 42)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
