import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InspireApp extends JFrame implements ActionListener 
{
    
    JLabel l1, l2, l3, order, cart, details, name, phone, email, history, line1, line2, developer;
    JButton myButton1, clear, proceed, signalButton, haircutButton, beardButton, hairspaButton, dandruffButton, matrixButton, majirelButton, inoaButton, cleanupButton, facialButton, whiteningButton, keratinButton, botoxButton, smootheningButton, rebondingButton, straighteningButton, silverButton, goldButton, platinumButton, specialButton;
    JTextField phoneNumberField;
    JTextArea nameTextArea, phoneTextArea, mailTextArea, historyTextArea, cartArea, totalArea;
    JRadioButton cashRadio, onlineRadio;
    ButtonGroup paymentGroup;
    int serial = 1, total;
    private static final String LICENSE_FILE_PATH = "license.txt";

    ImageIcon haircutIcon = new ImageIcon("Images/haircut.png");
    ImageIcon beardIcon = new ImageIcon("Images/beard.png");
    ImageIcon hairspaIcon = new ImageIcon("Images/hairspa.png");
    ImageIcon dandruffIcon = new ImageIcon("Images/dandruff.png");
    ImageIcon matrixIcon = new ImageIcon("Images/matrix.png");
    ImageIcon majirelIcon = new ImageIcon("Images/majirel.png");
    ImageIcon inoaIcon = new ImageIcon("Images/inoa.png");
    ImageIcon cleanupIcon = new ImageIcon("Images/cleanup.png");
    ImageIcon facialIcon = new ImageIcon("Images/facial.png");
    ImageIcon whiteningIcon = new ImageIcon("Images/whitening.png");
    ImageIcon keratinIcon = new ImageIcon("Images/keratin.png");
    ImageIcon botoxIcon = new ImageIcon("Images/botox.png");
    ImageIcon smootheningIcon = new ImageIcon("Images/smoothening.png");
    ImageIcon rebondingIcon = new ImageIcon("Images/rebonding.png");
    ImageIcon strentheningIcon = new ImageIcon("Images/straightening.png");
    ImageIcon silverIcon = new ImageIcon("Images/silver.png");
    ImageIcon goldIcon = new ImageIcon("Images/gold.png");
    ImageIcon platinumIcon = new ImageIcon("Images/platinum.png");
    ImageIcon specialIcon = new ImageIcon("Images/special.png");
    ImageIcon clearIcon = new ImageIcon("Images/clear.png");
    ImageIcon proceedIcon = new ImageIcon("Images/proceed.png");

    public InspireApp() 
    {
        setTitle("Inspire Men's Salon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //setSize(1920, 1040);
        setLocationRelativeTo(null); // Center the window
        setLayout(null); // Use null layout for manual positioning
        setVisible(true);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Header Section

        l1 = new JLabel("Inspire Men's Salon");
        l1.setBounds(10, 10, 1690, 95); // Adjust size and position as needed
        l1.setFont(new Font("Arial", Font.BOLD, 80)); // Set font with size 40
        l1.setBackground(Color.BLUE); // Set background color to blue
        l1.setForeground(Color.WHITE); // Set foreground (text) color to white
        l1.setOpaque(true); // Set opaque to true to make background visible
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        add(l1);

        //Image path should be updated to your specific image file location
        ImageIcon logoIcon = new ImageIcon("Images/logo.png");
        l2 = new JLabel(logoIcon);
        l2.setBounds(1710, 10, 200, 200); // Adjust size and position as needed
        add(l2);

        l3 = new JLabel("Rakesh Parmar - 6355809023             Tushar Parmar - 9328685986");
        l3.setBounds(10, 115, 1690, 95); // Adjust size and position as needed
        l3.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        l3.setBackground(Color.green); // Set background color to blue
        l3.setForeground(Color.WHITE); // Set foreground (text) color to white
        l3.setOpaque(true); // Set opaque to true to make background visible
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        add(l3);

        line1 = new JLabel();
        line1.setBounds(0, 220, 1920, 5); // Adjust size and position as needed
        line1.setBackground(Color.black); // Set background color to blue
        line1.setOpaque(true); // Set opaque to true to make background visible
        add(line1);

        line2 = new JLabel();
        line2.setBounds(958, 220, 5, 840); // Adjust size and position as needed
        line2.setBackground(Color.black); // Set background color to blue
        line2.setOpaque(true); // Set opaque to true to make background visible
        add(line2);


        // Body Section - Customer Order

        order = new JLabel("Customer Order");
        order.setBounds(300, 235, 350, 50); // Adjust size and position as needed
        order.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        order.setBackground(Color.blue); // Set background color to blue
        order.setForeground(Color.WHITE); // Set foreground (text) color to white
        order.setOpaque(true); // Set opaque to true to make background visible
        order.setHorizontalAlignment(SwingConstants.CENTER);
        add(order);

        phoneNumberField = new JTextField("Enter Phone No");
        phoneNumberField.setBounds(250, 305, 300, 50);
        phoneNumberField.setFont(new Font("Arial", Font.BOLD, 30));
        phoneNumberField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberField.setForeground(Color.GRAY); // Set the color of the placeholder text
        add(phoneNumberField);

        // Add a FocusListener to handle the placeholder behavior
        phoneNumberField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phoneNumberField.getText().equals("Enter Phone No")) {
                    phoneNumberField.setText("");
                    phoneNumberField.setForeground(Color.BLACK); // Change text color when focused
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phoneNumberField.getText().isEmpty()) {
                    phoneNumberField.setForeground(Color.GRAY); // Change text color when unfocused
                    phoneNumberField.setText("Enter Phone No");
                }
            }
        });

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(560, 305, 150, 50);
        searchButton.setFont(new Font("Arial", Font.BOLD, 30));
        add(searchButton);
        searchButton.addActionListener(this);

        haircutButton = new JButton();
        haircutButton.setBounds(20, 380, 100, 100);
        haircutButton.setIcon(haircutIcon); 
        add(haircutButton);
        haircutButton.addActionListener(this);

        beardButton = new JButton();
        beardButton.setBounds(140, 380, 100, 100);
        beardButton.setIcon(beardIcon);
        add(beardButton);
        beardButton.addActionListener(this);

        hairspaButton = new JButton();
        hairspaButton.setBounds(260, 380, 100, 100);
        hairspaButton.setIcon(hairspaIcon);
        add(hairspaButton);
        hairspaButton.addActionListener(this);

        dandruffButton = new JButton();
        dandruffButton.setBounds(380, 380, 100, 100);
        dandruffButton.setIcon(dandruffIcon);
        add(dandruffButton);
        dandruffButton.addActionListener(this);

        matrixButton = new JButton();
        matrixButton.setBounds(20, 500, 100, 100);
        matrixButton.setIcon(matrixIcon);
        add(matrixButton);
        matrixButton.addActionListener(this);

        majirelButton = new JButton();
        majirelButton.setBounds(140, 500, 100, 100);
        majirelButton.setIcon(majirelIcon);
        add(majirelButton);
        majirelButton.addActionListener(this);

        inoaButton = new JButton();
        inoaButton.setBounds(260, 500, 100, 100);
        inoaButton.setIcon(inoaIcon);
        add(inoaButton);
        inoaButton.addActionListener(this);

        cleanupButton = new JButton();
        cleanupButton.setBounds(380, 500, 100, 100);
        cleanupButton.setIcon(cleanupIcon);
        add(cleanupButton);
        cleanupButton.addActionListener(this);

        facialButton = new JButton();
        facialButton.setBounds(20, 620, 100, 100);
        facialButton.setIcon(facialIcon);
        add(facialButton);
        facialButton.addActionListener(this);

        whiteningButton = new JButton();
        whiteningButton.setBounds(140, 620, 100, 100);
        whiteningButton.setIcon(whiteningIcon);
        add(whiteningButton);
        whiteningButton.addActionListener(this);

        keratinButton = new JButton();
        keratinButton.setBounds(260, 620, 100, 100);
        keratinButton.setIcon(keratinIcon);
        add(keratinButton);
        keratinButton.addActionListener(this);

        botoxButton = new JButton();
        botoxButton.setBounds(380, 620, 100, 100);
        botoxButton.setIcon(botoxIcon);
        add(botoxButton);
        botoxButton.addActionListener(this);

        smootheningButton = new JButton();
        smootheningButton.setBounds(20, 740, 100, 100);
        smootheningButton.setIcon(smootheningIcon);
        add(smootheningButton);
        smootheningButton.addActionListener(this);

        rebondingButton = new JButton();
        rebondingButton.setBounds(140, 740, 100, 100);
        rebondingButton.setIcon(rebondingIcon);
        add(rebondingButton);
        rebondingButton.addActionListener(this);

        straighteningButton = new JButton();
        straighteningButton.setBounds(260, 740, 100, 100);
        straighteningButton.setIcon(strentheningIcon);
        add(straighteningButton);
        straighteningButton.addActionListener(this);

        silverButton = new JButton();
        silverButton.setBounds(380, 740, 100, 100);
        silverButton.setIcon(silverIcon);
        add(silverButton);
        silverButton.addActionListener(this);

        goldButton = new JButton();
        goldButton.setBounds(20, 860, 100, 100);
        goldButton.setIcon(goldIcon);
        add(goldButton);
        goldButton.addActionListener(this);

        platinumButton = new JButton();
        platinumButton.setBounds(140, 860, 100, 100);
        platinumButton.setIcon(platinumIcon);
        add(platinumButton);
        platinumButton.addActionListener(this);

        specialButton = new JButton();
        specialButton.setBounds(260, 860, 100, 100);
        specialButton.setIcon(specialIcon);
        add(specialButton);
        specialButton.addActionListener(this);

        clear = new JButton();
        clear.setBounds(380, 860, 100, 100);
        clear.setIcon(clearIcon);
        add(clear);
        clear.addActionListener(this);

        cart = new JLabel("Cart");
        cart.setBounds(545, 380, 350, 50); // Adjust size and position as needed
        cart.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        cart.setBackground(Color.blue); // Set background color to blue
        cart.setForeground(Color.WHITE); // Set foreground (text) color to white
        cart.setOpaque(true); // Set opaque to true to make background visible
        cart.setHorizontalAlignment(SwingConstants.CENTER);
        add(cart);

        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Arial", Font.PLAIN, 30));
        JScrollPane cartScroll = new JScrollPane(cartArea);
        cartScroll.setBounds(500, 450, 440, 290);
        add(cartScroll);

        JLabel totalLabel = new JLabel("Total Amount:");
        totalLabel.setBounds(500, 760, 200, 50); // Adjust size and position as needed
        totalLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(totalLabel);

        totalArea = new JTextArea();
        totalArea.setEditable(false);
        totalArea.setFont(new Font("Arial", Font.PLAIN, 30));
        totalArea.setBounds(710, 760, 228, 50);
        totalArea.setBackground(new Color(238,238,238));
        add(totalArea);

        JLabel paymentLabel = new JLabel("Payment Method");
        paymentLabel.setBounds(545, 840, 350, 50); // Adjust size and position as needed
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 35));
        paymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(paymentLabel);

        cashRadio = new JRadioButton("Cash");
        cashRadio.setBounds(580, 900, 120, 50); // Adjust size and position as needed
        cashRadio.setFont(new Font("Arial", Font.PLAIN, 30));
        add(cashRadio);

        onlineRadio = new JRadioButton("Online");
        onlineRadio.setBounds(740, 900, 120, 50); // Adjust size and position as needed
        onlineRadio.setFont(new Font("Arial", Font.PLAIN, 30));
        add(onlineRadio);

        paymentGroup = new ButtonGroup();
        paymentGroup.add(cashRadio);
        paymentGroup.add(onlineRadio);
        
        proceed = new JButton();
        proceed.setBounds(300, 980, 350, 50);
        proceed.setIcon(proceedIcon);
        add(proceed);
        proceed.addActionListener(this);

        // Body Section - Customer Data

        details = new JLabel("Customer Details");
        details.setBounds(1265, 235, 350, 50); // Adjust size and position as needed
        details.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        details.setBackground(Color.blue); // Set background color to blue
        details.setForeground(Color.WHITE); // Set foreground (text) color to white
        details.setOpaque(true); // Set opaque to true to make background visible
        details.setHorizontalAlignment(SwingConstants.CENTER);
        add(details);

        name = new JLabel(" Name");
        name.setBounds(980, 300, 300, 50); // Adjust size and position as needed
        name.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        name.setBackground(Color.green); // Set background color to blue
        name.setForeground(Color.WHITE); // Set foreground (text) color to white
        name.setOpaque(true); // Set opaque to true to make background visible
        add(name);

        phone = new JLabel(" Phone Number");
        phone.setBounds(980, 360, 300, 50); // Adjust size and position as needed
        phone.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        phone.setBackground(Color.green); // Set background color to blue
        phone.setForeground(Color.WHITE); // Set foreground (text) color to white
        phone.setOpaque(true); // Set opaque to true to make background visible
        add(phone);

        email = new JLabel(" Email ID");
        email.setBounds(980, 420, 300, 50); // Adjust size and position as needed
        email.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        email.setBackground(Color.green); // Set background color to blue
        email.setForeground(Color.WHITE); // Set foreground (text) color to white
        email.setOpaque(true); // Set opaque to true to make background visible
        add(email);

        history = new JLabel("Customer History");
        history.setBounds(1265, 480, 350, 50); // Adjust size and position as needed
        history.setFont(new Font("Arial", Font.BOLD, 40)); // Set font with size 40
        history.setBackground(Color.green); // Set background color to blue
        history.setForeground(Color.WHITE); // Set foreground (text) color to white
        history.setHorizontalAlignment(SwingConstants.CENTER);
        history.setOpaque(true); // Set opaque to true to make background visible
        add(history);

        nameTextArea = new JTextArea();
        nameTextArea.setBounds(1300, 300, 600, 50);
        nameTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        nameTextArea.setBackground(new Color(238,238,238));
        nameTextArea.setEditable(false);
        add(nameTextArea);

        phoneTextArea = new JTextArea();
        phoneTextArea.setBounds(1300, 360, 600, 50);
        phoneTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        phoneTextArea.setBackground(new Color(238,238,238));
        phoneTextArea.setEditable(false);
        add(phoneTextArea);

        mailTextArea = new JTextArea();
        mailTextArea.setBounds(1300, 420, 600, 50);
        mailTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        mailTextArea.setBackground(new Color(238,238,238));
        mailTextArea.setEditable(false);
        add(mailTextArea);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        scrollPane.setBounds(980, 540, 920, 400);
        add(scrollPane);

        developer = new JLabel("App Developer : Shashank Bagda");
        developer.setBounds(1265, 980, 350, 50); // Adjust size and position as needed
        developer.setFont(new Font("Arial", Font.BOLD, 20)); // Set font with size 40
        developer.setBackground(Color.green); // Set background color to blue
        developer.setForeground(Color.blue); // Set foreground (text) color to white
        developer.setHorizontalAlignment(SwingConstants.CENTER);
        developer.setOpaque(true); // Set opaque to true to make background visible
        add(developer);

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Search"))
        {
            String phoneNumber = phoneNumberField.getText();
            String phonePattern = "\\d{10}";

            if(!phoneNumber.equals("Enter Phone No") && phoneNumber.matches(phonePattern))
            {
                nameTextArea.setText("");
                phoneTextArea.setText("");
                mailTextArea.setText("");
                historyTextArea.setText("");
                // System.out.println("Phone Number: " + phoneNumber);

                String fileName = phoneNumber + ".txt";
                
                File file = new File("Customers/" + fileName); // Assuming the file is in the "Customers" directory
                if (file.exists()) 
                {
                    try 
                    {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;

                        String userData = reader.readLine();
                        String[] userDataArray = userData.split(" / ");

                        String name = userDataArray[0];
                        String phone = userDataArray[1];
                        String mailID = userDataArray[2];

                        nameTextArea.setText(name);
                        phoneTextArea.setText(phone);
                        mailTextArea.setText(mailID);

                        //historyTextArea.setText("Order History:\n");
                        while ((line = reader.readLine()) != null) {
                            historyTextArea.append(line + "\n");
                        }

                        reader.close();
                    } 
                    
                    catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } 
                else 
                {
                    System.out.println("File '" + fileName + "' does not exist.");

                    String name = JOptionPane.showInputDialog(null, "Enter Name:");
                    String phone = JOptionPane.showInputDialog(null, "Enter Phone Number:");
                    String mailID = JOptionPane.showInputDialog(null, "Enter Mail ID:");

                    // Write user data to a new file
                    try 
                    {
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter writer = new BufferedWriter(fileWriter);

                        // Write user data to the file
                        writer.write(name + " / " + phone + " / " + mailID);
                        writer.newLine(); // Add newline to separate user data from orders if any

                        writer.close();
                    } 
                    
                    catch (IOException ex) 
                    {
                        ex.printStackTrace();
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Enter Phone Number to proceed");
            }   
        }

        if (e.getSource() == haircutButton) {
            addToCartAndUpdateTotal(250, "Hair Cut");
        }

        if (e.getSource() == beardButton) {
            addToCartAndUpdateTotal(100, "Beard");
        }

        if (e.getSource() == hairspaButton) {
            addToCartAndUpdateTotal(500, "Hair Spa");
        }

        if (e.getSource() == dandruffButton) {
            addToCartAndUpdateTotal(700, "Dandruff Treatment");
        }

        if (e.getSource() == matrixButton) {
            addToCartAndUpdateTotal(500, "Matrix Hair Color");
        }

        if (e.getSource() == majirelButton) {
            addToCartAndUpdateTotal(600, "L'oreal Majirel Color");
        }

        if (e.getSource() == inoaButton) {
            addToCartAndUpdateTotal(700, "L'oreal INOA Color");
        }

        if (e.getSource() == cleanupButton) {
            addToCartAndUpdateTotal(350, "Clean Up");
        }

        if (e.getSource() == facialButton) {
            addToCartAndUpdateTotal(1000, "Facial");
        }

        if (e.getSource() == whiteningButton) {
            addToCartAndUpdateTotal(1800, "Whitening Facial");
        }

        if (e.getSource() == keratinButton) {
            addToCartAndUpdateTotal(1500, "Keratin Treatment");
        }

        if (e.getSource() == botoxButton) {
            addToCartAndUpdateTotal(3000, "Botox Treatment");
        }

        if (e.getSource() == smootheningButton) {
            addToCartAndUpdateTotal(4000, "Smoothening Treatment");
        }

        if (e.getSource() == rebondingButton) {
            addToCartAndUpdateTotal(4500, "Rebonding Treatment");
        }

        if (e.getSource() == straighteningButton) {
            addToCartAndUpdateTotal(5000, "Hair Straightening");
        }

        if (e.getSource() == silverButton) {
            addToCartAndUpdateTotal(7500, "Silver Package");
        }

        if (e.getSource() == goldButton) {
            addToCartAndUpdateTotal(10000, "Gold Package");
        }

        if (e.getSource() == platinumButton) {
            addToCartAndUpdateTotal(14000, "Platinum Package");
        }

        if (e.getSource() == specialButton) {
            addToCartAndUpdateTotal(7200, "Special Grooming Package");
        }

        if (e.getSource() == clear) {
            totalArea.setText("");
            cartArea.setText("");
            serial = 1;
        }

        if (e.getSource() == proceed) 
        {
            String phoneNumber = phoneTextArea.getText();
            String fileName = "Customers/" + phoneNumber + ".txt";
            String cartData = cartArea.getText();

            if (!cartData.isEmpty() && !phoneNumber.isEmpty()) 
            {
                String totalAmount = "example.txt"; // File name or path

                try {
                    FileWriter fileWriter = new FileWriter(totalAmount); // FileWriter to write to a file
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // BufferedWriter for efficient writing

                    bufferedWriter.write(totalArea.getText()); // Writing text to the file

                    bufferedWriter.close(); // Close the writer

                    System.out.println("Data has been written to " + totalAmount);
                } catch (IOException se) {
                    System.err.println("Error writing to the file: " + se.getMessage());
                }

                if (cashRadio.isSelected()) 
                {
                    // Process for normal transaction
                    // Your existing code here...
                } 
                else if (onlineRadio.isSelected()) 
                {
                    String value = totalArea.getText();
                    if (!value.isEmpty()) {
                        try 
                        {
                            ProcessBuilder pb = new ProcessBuilder("python", "main.py");
                            pb.redirectErrorStream(true);
                            Process p = pb.start();
                            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            String line3;
                            while ((line3 = in.readLine()) != null) {
                                System.out.println(line3);
                            }
                            in.close();
                        } 
                        catch (IOException e4) 
                        {
                            e4.printStackTrace();
                        }
                    } else {
                        // Inform the user that the value is empty (optional)
                        JOptionPane.showMessageDialog(null, "Value is empty.");
                    }
                }

                try {
                    // Get the current date and time
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedDateTime = currentDateTime.format(dateFormatter);

                    // Prepare the data to be appended
                    String dataToAppend = "\n--- " + formattedDateTime + " ---\n\n" + cartData;

                    // Append cart data to the phoneNumber.txt file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                    writer.write(dataToAppend);
                    writer.newLine();
                    writer.close();

                    // Clear cartArea after data is successfully appended
                    cartArea.setText("");
                    totalArea.setText("");
                    nameTextArea.setText("");
                    phoneTextArea.setText("");
                    mailTextArea.setText("");
                    historyTextArea.setText("");
                    phoneNumberField.setText("");

                    // Inform the user about the successful operation (optional)
                    JOptionPane.showMessageDialog(null, "Cart data added successfully.");

                    serial = 1;
                } catch (IOException ex) {
                    ex.printStackTrace(); // Handle file writing errors
                }
            } 
            else {
                // Inform the user that the cart is empty (optional)
                JOptionPane.showMessageDialog(null, "Cart is empty or Search Customer to proceed.");
            }
        }        
    }

    private void addToCartAndUpdateTotal(int price, String serviceName) {
        cartArea.append(serial + ". " + serviceName + " - " + price + "\n");
        serial++;
        
        String currentTotalText = totalArea.getText();
        int currentTotal = 0;
        
        try {
            currentTotal = Integer.parseInt(currentTotalText);
        } catch (NumberFormatException ex) {
            ex.printStackTrace(); // Handle parsing errors if the text is not a valid number
        }
        
        currentTotal += price;
        totalArea.setText(String.valueOf(currentTotal));
    }

    private static boolean validateLicense() {
        File licenseFile = new File(LICENSE_FILE_PATH);
        if (!licenseFile.exists()) {
            System.out.println("License file not found.");
            return false;
        }
    
        String extractedNumbersAndSymbol = null; // Declare outside the try block
    
        try (BufferedReader br = new BufferedReader(new FileReader(LICENSE_FILE_PATH))) {
            String line;
            StringBuilder key = new StringBuilder();
    
            while ((line = br.readLine()) != null) {
                key.append(line).append("\n");
                //System.out.println(line); // Printing the line, you can perform operations here
            }
            //System.out.println(key);
    
            // Regular expression to match numbers and the '-' symbol
            Pattern pattern = Pattern.compile("[0-9-]+");
            Matcher matcher = pattern.matcher(key);
    
            StringBuilder result = new StringBuilder();
    
            // Extracting numbers and '-' symbol and storing in a string
            while (matcher.find()) {
                result.append(matcher.group());
            }
    
            extractedNumbersAndSymbol = result.toString();
            System.out.println("License Expiration: " + extractedNumbersAndSymbol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (extractedNumbersAndSymbol != null) {
            // Assuming extractedNumbersAndSymbol is the expiration date in ISO_DATE format
            LocalDate expirationDate = LocalDate.parse(extractedNumbersAndSymbol, DateTimeFormatter.ISO_DATE);
            LocalDate currentDate = LocalDate.now();
    
            return !currentDate.isAfter(expirationDate); // Check if the current date is before or equal to the expiration date
        } else {
            return false; // Or handle this case based on your logic
        }
    }
    

    private static void showExpiredMembershipMessage() {
        JOptionPane.showMessageDialog(
                null,
                "Your membership has expired. Please renew or purchase a new membership.",
                "Membership Expired",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void main(String[] args) 
    {
        try 
        {
            ProcessBuilder pb = new ProcessBuilder("python", "bootup.py");
            pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line3;
            while ((line3 = in.readLine()) != null) {
                System.out.println(line3);
            }
            in.close();
        } 
        catch (IOException e4) 
        {
            e4.printStackTrace();
        }
        boolean isValid = validateLicense();
        if (isValid) {
            System.out.println("License is valid. Access granted.");
            SwingUtilities.invokeLater(() -> 
            {
                new InspireApp();
            });
        } else {
            System.out.println("License is invalid or expired. Please renew or purchase a new license.");
            showExpiredMembershipMessage();
            // Prompt the user to renew/purchase a license or restrict access
        }
    }
}
