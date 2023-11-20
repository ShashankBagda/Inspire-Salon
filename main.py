import qrcode
import os

def generate_upi_qr_code(amount, upi_id):
    # UPI payment format: upi://pay?pa=<UPI_ID>&pn=<Name>&am=<Amount>&cu=INR&tid=<TransactionID>&mc=<MerchantCode>&tr=<RefID>
    upi_data = f"upi://pay?pa={upi_id}&am={amount}&cu=INR"

    # Create QR code instance
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_L,
        box_size=10,
        border=4,
    )

    # Add UPI payment data to QR code
    qr.add_data(upi_data)
    qr.make(fit=True)

    # Create an image from the QR code
    qr_img = qr.make_image(fill_color="black", back_color="white")

    return qr_img

# Read bill amount from a text file
def get_bill_amount_from_file(file_name):
    try:
        with open(file_name, 'r') as file:
            amount = int(file.read().strip())
            return amount
    except FileNotFoundError:
        print("File not found!")
    except ValueError:
        print("Invalid data format in the file!")

# File containing the bill amount
file_with_amount = "example.txt"
customer_upi_id = "shashankbagda167@okicici"

# Get the bill amount from the file
bill_amount = get_bill_amount_from_file(file_with_amount)

# If bill amount is retrieved successfully, generate UPI payment QR code
if bill_amount is not None:
    qr_code = generate_upi_qr_code(bill_amount, customer_upi_id)
    # Display the QR code without saving
    qr_code.show()

os.remove(file_with_amount)