package test.leanftexample.pages;

import com.hp.lft.sdk.Description;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.*;

import java.util.List;

/**
 * Created by dsoxAndreas on 20/04/2016.
 */
public class CalculatorStandardView {

    private Window calculator;

    Description plusButton = new ButtonDescription.Builder().windowId(93).nativeClass("Button").build();
    Description equalsButton = new ButtonDescription.Builder().windowId(121).nativeClass("Button").build();

    public CalculatorStandardView() throws GeneralLeanFtException {
        // Create the WindowDescription object for the Calculator application window.
        WindowDescription calculatorDescription = new WindowDescription.Builder().nativeClass("CalcFrame").build();
        // Locate the Calculator window and assign it to an Window object.
        this.calculator = Desktop.describe(Window.class, calculatorDescription);
    }

    public CalculatorStandardView AddNumbers(List<Integer> numbers) throws GeneralLeanFtException {
        for (int i = 0; i < numbers.size() ; i++) {
            Button buttonNumber = calculator.describe(Button.class, new ButtonDescription.Builder().windowId(130 + numbers.get(i)).nativeClass("Button").build());
            buttonNumber.click();
            if (i < numbers.size()-1)
                calculator.describe(Button.class, plusButton).click();
        }
        calculator.describe(Button.class, equalsButton).click();
        return this;
    }

    public String getResult() throws GeneralLeanFtException {
        // Identify the Calculator window static text.
        Static textBox = calculator.describe(Static.class, new StaticDescription.Builder().windowId(150).nativeClass("Static").build());
        return textBox.getVisibleText();
    }
}
