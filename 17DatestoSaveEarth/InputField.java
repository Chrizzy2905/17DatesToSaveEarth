import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InputField extends Actor
{
    private String inputText = "";  // Text the user is typing
    private boolean focused = false;  // Whether the field is focused (clicked on)

    public InputField()
    {
        updateImage();
    }

    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            focused = true;  // Focus the input field when clicked
        }

        if (focused) 
        {
            // Capture keyboard input while the field is focused
            if (Greenfoot.isKeyDown("backspace") && inputText.length() > 0) 
            {
                inputText = inputText.substring(0, inputText.length() - 1);  // Remove last character
            } 
            else if (Greenfoot.isKeyDown("enter")) 
            {
                // You can handle the "enter" key here (e.g., submit input)
                System.out.println("Input Submitted: " + inputText);
                focused = false;  // Unfocus the input field
            }
            else 
            {
                // Capture any other characters typed
                for (char c = 'a'; c <= 'z'; c++) 
                {
                    if (Greenfoot.isKeyDown(String.valueOf(c))) 
                    {
                        inputText += c;  // Add character to the input string
                        updateImage();
                        break;  // Prevent adding the same key multiple times
                    }
                }
            }
        }
    }

    private void updateImage()
    {
        // Update the visual representation of the input text
        GreenfootImage img = new GreenfootImage(200, 30);  // Size of the input field
        img.setColor(Color.WHITE);
        img.fillRect(0, 0, 200, 30);  // Background of input field

        img.setColor(Color.BLACK);
        img.drawString(inputText, 10, 20);  // Draw the text inside the field

        setImage(img);  // Set the actor's image
    }

    public String getInputText()
    {
        return inputText;
    }
}
