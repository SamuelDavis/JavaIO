/* Author Name: Samuel Davis
 * Description: collection of I/O operations utilizing JOptionPanes
 */
package sdavis_week6;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Arrays;

//Begin Class GetIO
public class myIO {

//GET
    Scanner userInput = new Scanner(System.in);

    int getInt(String title, String msg) {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE));
        } catch (NumberFormatException nFE) {
            JOptionPane.showMessageDialog(null, "Please enter an integer");
            return this.getInt(title, msg);
            //throw new NullPointerException();
        }
    }

    double getDouble(String title, String msg) {
        try {
            return Double.parseDouble(
                    JOptionPane.showInputDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE));
        } catch (NumberFormatException nFE) {
            JOptionPane.showMessageDialog(null, "Please enter a double");
            System.out.println("Not a Double");
            return this.getDouble(title, msg);
            //throw new NullPointerException();
        }
    }

    char getChar(String title, String msg) {
        try {
            return JOptionPane.showInputDialog(null, msg, title).charAt(0);
            //return userInput.nextLine().charAt(0);
        } catch (NumberFormatException nFE) {
            JOptionPane.showMessageDialog(null, "Please enter a char");
            return this.getChar(title, msg);
            //throw new NullPointerException();
        }
    }

    String getString(String title, String msg) {
        try {
            return JOptionPane.showInputDialog(null, msg, title);
        } catch (NumberFormatException nFE) {
            JOptionPane.showMessageDialog(null, "Please enter a string");
            return this.getString(title, msg);
            //throw new NullPointerException();
        }
    }

    boolean getBool(String title, String msg) {
        int bool = JOptionPane.showConfirmDialog(
                null,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (bool == 0) {
            return true;
        } else if (bool == 1) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Please choose yes or no");
            return this.getBool(title, msg);
        }
    }

    boolean getBool(String title, String msg, String b1, String b2) {
        Object[] options = {b1,
            b2};
        int bool = JOptionPane.showOptionDialog(
                null,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                null);
        if (bool == 0) {
            return true;
        } else if (bool == 1) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Please choose " + b1 + " or " + b2);
            return this.getBool(title, msg, b1, b2);
        }
    }

    int getButtons(String title, String msg, String options, String delim) {
        int in = JOptionPane.showOptionDialog(
                null,
                msg,
                title,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options.split(delim),
                null);
        if(in >= 0 && in < options.split(delim).length){
            return in;
        }
        else{
            JOptionPane.showMessageDialog(null, "Please choose an option");
            return this.getButtons(title, msg, options, delim);
        }
            
    }

    String getDrop(String title, String msg, String options, String delim) {
        String in = (String) JOptionPane.showInputDialog(
                null,
                msg,
                title,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options.split(delim),
                null);
        if(!in.equals(null)){
            return in;
        } else {
            JOptionPane.showMessageDialog(null, "Please choose an option");
            return this.getDrop(title, msg, options, delim);
        }
    }
    
    String[] getArray(String title, String msg, String delim, int size){
        String[] s = this.getString(title, msg).split(delim);
        if(s.length == size){
            return s;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a string of " + size + " elements separated by a " + delim);
            return this.getArray(title, msg, delim, size);
        }
        
    }

//PUT
    public void putMessage(String title, String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                title,
                JOptionPane.PLAIN_MESSAGE);
    }

    public void putArray(String title, String[] arr, String delim) {
        String array = "";
        for (int i = 0; i < arr.length; i++) {
            array += arr[i] + delim;
        }
        JOptionPane.showMessageDialog(
                null,
                array,
                title,
                JOptionPane.PLAIN_MESSAGE);
    }
    
//CONVERSIONS
    public int[] strArr2intArr(String[] strArr){
        int intArr[] = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            intArr[i]= Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    
    public String intArr2strArr(int[] intArr, String delim){
        return Arrays.toString(intArr).replace(", ", delim);
    }
    
} //End Class GetIO