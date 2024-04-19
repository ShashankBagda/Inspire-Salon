from datetime import datetime
from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas
import time
import pyautogui

def send_file(number, location, message):
    command = 'start explorer.exe ' + location

    # Simulate opening WhatsApp
    pyautogui.hotkey('win', 's')
    time.sleep(1)
    pyautogui.write("WhatsApp")
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(1)
    pyautogui.write(number)
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(1)
    pyautogui.press('tab')
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(1)

    pyautogui.hotkey('win', 'r')
    time.sleep(1)
    pyautogui.write(location)
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(1)
    pyautogui.press('space')
    time.sleep(1)
    pyautogui.hotkey('ctrl', 'c')
    time.sleep(1)
    pyautogui.hotkey('alt', 'f4')
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(1)
    pyautogui.hotkey('ctrl', 'v')
    time.sleep(1)
    pyautogui.write(message)
    time.sleep(1)
    pyautogui.press('enter')
    time.sleep(5)
    pyautogui.hotkey('alt', 'f4')

def create_bill(filename):
    try:
        with open(filename, 'r') as file:
            # Read customer information
            customer_info = file.readline().strip().split(' / ')
            customer_name = customer_info[0]
            customer_phone = customer_info[1]
            customer_email = customer_info[2]

            # Read items and prices
            items = []
            total = 0
            for line in file:
                if line.strip():
                    line_parts = line.strip().split(' - ')
                    if len(line_parts) == 2:
                        item, price = line_parts
                        items.append((item.strip(), float(price.strip())))
                        total += float(price.strip())
                    else:
                        print("Invalid line format:", line.strip())

            # Get current date and time
            date_time = datetime.now().strftime('%d-%m-%Y %H:%M:%S')

            # Generate PDF
            pdf_path = "Bill/Bill.pdf"  # Adjust the path as needed
            generate_pdf(pdf_path, customer_name, customer_phone, customer_email, date_time, items, total)
            print("PDF generated successfully: Bill.pdf")

            # Call send_file function to send the generated PDF
            message = "Thank You for Visiting Us !! Here's your Digital Bill."
            location = 'D:/Mirror/GITHUB/Inspire App/Bill'
            send_file(customer_phone, location, message)

    except FileNotFoundError:
        print("File not found.")

def generate_pdf(output_path, customer_name, customer_phone, customer_email, date_time, items, total):
    c = canvas.Canvas(output_path, pagesize=letter)

    # Add logo to the center
    logo_path = 'Images/logo.png'
    c.drawImage(logo_path, 260, 690, width=100, height=100)

    # Add title
    c.setFont("Helvetica-Bold", 20)
    c.drawCentredString(310, 660, "Checkout Bill")

    # Add customer information
    c.setFont("Helvetica", 12)
    c.drawString(220, 630, f"Customer Name: {customer_name}")
    c.drawString(220, 610, f"Phone: {customer_phone}")
    c.drawString(220, 590, f"Email: {customer_email}")

    # Add date and time
    c.drawString(220, 550, f"Date and Time: {date_time}")

    c.drawString(260, 510, f"--- Billing Items ---")

    # Add items
    y_offset = 480
    for i, (item, price) in enumerate(items, 1):
        c.drawString(220, y_offset, f"{i}. {item}: {price:.2f}/-")
        y_offset -= 20

    # Add total
    c.drawString(220, y_offset - 20, f"Total: {total:.2f}/-")

    c.save()

# Replace 'cart.txt' with the path to your file
create_bill('cart.txt')
