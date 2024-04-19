# Open the total.txt file in read mode
import time
import pyautogui


with open('total.txt', 'r') as file:
    # Read lines from the file
    lines = file.readlines()
    
    # Iterate through each line
    for line in lines:
        # Split the line by ' - ' to separate phone number and OTP
        parts = line.strip().split(' - ')
        if len(parts) == 2:
            phone_number, otp = parts
            print("Phone Number:", phone_number)
            print("OTP:", otp)

            pyautogui.hotkey('win', 's')
            time.sleep(1)
            pyautogui.write("WhatsApp")
            time.sleep(1)
            pyautogui.press('enter')
            time.sleep(1)
            pyautogui.write(phone_number)
            time.sleep(1)
            pyautogui.press('enter')
            time.sleep(1)
            pyautogui.press('tab')
            time.sleep(1)
            pyautogui.press('enter')
            time.sleep(1)
            pyautogui.write("Welcome to Inspire Men's Salon. Your Registration OTP is : " + otp)
            time.sleep(1)
            pyautogui.press('enter')
            time.sleep(1)
            pyautogui.hotkey('alt', 'f4')