
package eventsmain;

import java.util.Arrays;
import javax.swing.*;

public class NewWindow {
    public void sum(){
    
    String numCount = JOptionPane.showInputDialog("How many numbers do you want to add?");
    try{
    int numCount1 = Integer.parseInt(numCount);
    int sum=0;
    int numList[] = new int[numCount1];
    for(int i=0; i < numCount1; i++){
            String numberStr = JOptionPane.showInputDialog("Enter number "+ (i+1));
            numList[i] = Integer.parseInt(numberStr);
            sum = sum+numList[i];
    }
    JOptionPane.showMessageDialog(null,"Result of "+Arrays.toString(numList)+" is "+sum);
    } catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Invalid Number Format.");
        return;
    }
}
    
}
